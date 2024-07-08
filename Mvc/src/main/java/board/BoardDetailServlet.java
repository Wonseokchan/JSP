package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/detail")
public class BoardDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long searchno = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService();
		BoardVO board = service.selectBoard(searchno);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
	}
}
