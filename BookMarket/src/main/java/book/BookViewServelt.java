package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books/view")
public class BookViewServelt extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchId = req.getParameter("id");
		BookService service = BookService.getInstance();
		BookVO book = service.selectBook(searchId);
		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/views/book/view.jsp").forward(req, resp);

	}
}
