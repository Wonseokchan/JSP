package book;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/books/update")
@MultipartConfig
public class BookUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateId = req.getParameter("id");
		BookService service = BookService.getInstance();
		BookVO book = service.selectBook(updateId);

		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/views/book/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		String title = req.getParameter("title");
		int price = req.getParameter("price").isEmpty() ? 0 : Integer.parseInt(req.getParameter("price"));
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String releaseDateStr = req.getParameter("releaseDate");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		long quantity = req.getParameter("quantity").isEmpty() ? 0 : Long.parseLong(req.getParameter("quantity"));
		String condition = req.getParameter("condition");

		LocalDate releaseDate = LocalDate.parse(releaseDateStr);

		Part part = req.getPart("imageFile");
		String filename = id + ".jpg";
		Path path = Paths.get("c:\\", "Users", "user", "book", "images", filename);

		part.write(path.toString());
		BookService service = BookService.getInstance();
		BookVO book = book = new BookVO(id, title, price, author, description, publisher, category, quantity,
				releaseDate, condition, filename);
		int executeUpdate = service.updateBook(book);
		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/books");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(req, resp);
		}

	}
}
