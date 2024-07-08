package book;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books/image")
public class BookImageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String filename = id + ".jpg";
		Path path = Paths.get("c:\\", "users", "user", "book", "images", filename);
		resp.setHeader("Content-Type", "application/octet-stream");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Content-Disposition", "attachement;filename=" + filename + ";");

		OutputStream outputStream = resp.getOutputStream();

		Files.copy(path, outputStream);

	}
}
