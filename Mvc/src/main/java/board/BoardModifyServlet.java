package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/modify")
public class BoardModifyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long searchno = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService();
		BoardVO board = service.selectBoard(searchno);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/modify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		long updateno = Long.parseLong(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		BoardService service = new BoardService();
		BoardVO board = new BoardVO(updateno, title, content, writer);
		int executeUpdate = service.modifyBoard(board);
		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/boards");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/board/modify.jsp").forward(req, resp);
		}
	}
}
