package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members/view")
public class MemberViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long searchId = Long.parseLong(req.getParameter("id"));
		MemberService service = MemberService.getInstance();
		MemberVO member = service.selectMember(searchId);
		req.setAttribute("member", member);
		req.getRequestDispatcher("/WEB-INF/views/member/view.jsp").forward(req, resp);
	}
}
