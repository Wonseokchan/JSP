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

@WebServlet("/books/insert")
@MultipartConfig
public class BookInsetServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/book/new.jsp").forward(req, resp);
		req.setCharacterEncoding("utf-8");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		int price = req.getParameter("price").isEmpty() ? 0 : Integer.parseInt(req.getParameter("price"));
		String author = req.getParameter("author");
		String description = req.getParameter("description");
		String publisher = req.getParameter("publisher");
		String category = req.getParameter("category");
		long quantity = req.getParameter("quantity").isEmpty() ? 0 : Long.parseLong(req.getParameter("quantity"));
		String releaseDateStr = req.getParameter("releaseDate");
		String condition = req.getParameter("condition");
		// 첨부파일은 Part라는 객체(인터페이스)로 처리할 수 있다
		Part part = req.getPart("imageFile");
		// .getSubmittedFileName(); 원본파일이름
		String filename = id + ".jpg";
		Path path = Paths.get("c:\\", "users", "user", "book", "images", filename);

		LocalDate releaseDate = LocalDate.parse(releaseDateStr);

		part.write(path.toString());
		BookService service = BookService.getInstance();
		BookVO book = new BookVO(id, title, price, author, description, publisher, category, quantity, releaseDate,
				condition, filename);
		int executeUpdate = service.insertBook(book);
		if (executeUpdate > 0) {
			resp.sendRedirect(req.getContextPath() + "/books");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(req, resp);
		}

	}

}
