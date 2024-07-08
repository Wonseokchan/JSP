package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/boards/update")
public class BoardUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");

		long no = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService(session);
		BoardVO board = service.selectBoard(no);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long no = Long.parseLong(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");

		BoardService service = new BoardService(session);
		BoardVO board = new BoardVO(no, title, content, writer);
		int executeUpdate = service.updateBoard(board);

		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/boards");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}
	}
}
