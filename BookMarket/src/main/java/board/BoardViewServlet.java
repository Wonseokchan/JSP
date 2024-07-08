package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/boards/view")
public class BoardViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");

		Long no = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService(session);
		BoardVO board = service.selectBoard(no);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
	}
}
