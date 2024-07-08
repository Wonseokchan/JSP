package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/boards/delete")
public class BoardDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");

		long no = Long.parseLong(req.getParameter("no"));
		BoardService service = new BoardService(session);
		int executeUpdate = service.deleteBoard(no);

		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/boards");
		} else {
			req.setAttribute("msg", "게시글 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(req, resp);
		}
	}
}
