package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members/delete")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long deleteid = Long.parseLong(req.getParameter("id"));
		MemberService service = MemberService.getInstance();

		int executeUpdate = service.deleteMember(deleteid);

		if (executeUpdate > 0) {
			resp.sendRedirect("/members");
		} else {
			resp.sendRedirect("/members/view?id=" + deleteid);
		}
	}
}
