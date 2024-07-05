package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members/new")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/views/member/newMember.jsp").forward(request, response);
		response.setContentType("text/html; charset=utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		MemberVO member = new MemberVO(email, password, name);
		MemberService service = MemberService.getInstance();
		int executeUpdate = service.insertMember(member);

		if (executeUpdate > 0) {
			response.sendRedirect("/members");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/member/newMember.jsp").forward(request, response);
		}
	}
}
