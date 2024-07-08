package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService service = BookService.getInstance();
		List<BookVO> book = service.selectBooks();
		req.setAttribute("books", book);
		req.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(req, resp);

	}
}
