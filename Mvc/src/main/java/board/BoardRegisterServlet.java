package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boards/register")
public class BoardRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
		resp.setContentType("text/html; charset=utf-8");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		BoardVO board = new BoardVO(title, content, writer);
		BoardService service = new BoardService();
		int executeUpdate = service.registerBoard(board);

		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/boards");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
		}
	}
}
