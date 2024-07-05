package signin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;

@WebServlet("/cookie/signin")
public class SignInCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if ("rememberId".equals(cookie.getName())) {
				String rememberId = cookie.getValue();
				req.setAttribute("rememberId", rememberId);
			}
		}
		req.getRequestDispatcher("/WEB-INF/views/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("email : " + email);
		System.out.println("password : " + password);
		String rememberId = req.getParameter("rememberId");

		Cookie rememberIdCookie = new Cookie("rememberId", email);
		rememberIdCookie.setPath("/");

		if ("true".equals(rememberId)) {
			rememberIdCookie.setMaxAge(60 * 60 * 24 * 90);

		} else {
			rememberIdCookie.setMaxAge(0);
		}
		resp.addCookie(rememberIdCookie);
		// 쿠키에 데이터 저장
		SignInService service = new SignInService();
		MemberVO member = service.findByEmail(new SignInVO(email, password));

		if (member != null) {
			Cookie emailCK = new Cookie("email", member.getEmail());
			Cookie passwordCK = new Cookie("password", password);
			emailCK.setPath("/");
			passwordCK.setPath("/");
			resp.addCookie(emailCK);
			resp.addCookie(passwordCK);
			resp.sendRedirect(req.getContextPath() + "/members");
		} else {
			req.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다");
			req.getRequestDispatcher("/WEB-INF/views/signin.jsp").forward(req, resp);
		}
	}
}
