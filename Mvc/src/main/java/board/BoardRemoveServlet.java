package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/remove")
public class BoardRemoveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long deleteno = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService();
		int executeUpdate = service.removeBoard(deleteno);

		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/boards");
		} else {
			resp.sendRedirect("/Mvc/boards/detail?no=" + deleteno);
		}
	}
}
