package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/members/update")
public class MemberUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long searchId = Long.parseLong(req.getParameter("id"));
		MemberService service = MemberService.getInstance();
		MemberVO member = service.selectMember(searchId);
		// 세션정보 꺼내오기
		HttpSession session = req.getSession();
		MemberVO sessionMember = (MemberVO) session.getAttribute("member");
		if (sessionMember != null && member.getId() == sessionMember.getId()) {
			req.setAttribute("member", member);
			req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
		} else {
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('회원정보를 수정할 수 없습니다');");
			out.println("location.href='/signin'");
			out.println("</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		long updateid = Long.parseLong(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");

		MemberService service = MemberService.getInstance();
		MemberVO member = new MemberVO(updateid, email, password, name);
		int executeUpdate = service.updateMember(member);

		if (executeUpdate > 0) {
			resp.sendRedirect("/members");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
		}

	}
}
