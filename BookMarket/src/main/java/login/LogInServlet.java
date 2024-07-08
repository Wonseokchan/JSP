package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("rememberMe");

		LogInService service = LogInService.getInstance();
		MemberVO member = service.findByEmailAndPassword(new LoginVO(email, password));
		if (member != null) {
			HttpSession session = req.getSession();
			session.setAttribute("member", member);
			if ("remember-me".equals(rememberMe)) {
				Cookie cookie = new Cookie("rememberMe", email);
				cookie.setPath(req.getContextPath() + "/");
				cookie.setMaxAge(60 * 60 * 24 * 100);
				resp.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("rememberMe", null);
				cookie.setPath(req.getContextPath() + "/");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			String retUrl = (String) session.getAttribute("retUrl");
			String url = retUrl != null ? retUrl : req.getContextPath() + "/";
			resp.sendRedirect(url);

			// 세션에 남아 있는 retUrl 제거
			session.removeAttribute(retUrl);
		} else {
			req.setAttribute("error-msg", "아이디 또는 비밀번호가 올바르지 않습니다");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		}
	}
}
