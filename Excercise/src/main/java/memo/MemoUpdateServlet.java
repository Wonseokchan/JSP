package memo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memos/update")
public class MemoUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int searchNo = Integer.parseInt(req.getParameter("no"));

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = """
						SELECT
							no,
							title,
							content,
							writer,
							register_date,
							modified_date
						FROM
							memo
						WHERE
							no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchNo);
			resultSet = statement.executeQuery();
			MemoVO memo = null;
			if (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date registerDate = resultSet.getDate("register_date");
				Date modifiedDate = resultSet.getDate("modified_date");
				memo = new MemoVO(no, title, content, writer, registerDate.toLocalDate(), modifiedDate.toLocalDate());
			}
			req.setAttribute("memo", memo);
			req.getRequestDispatcher("/WEB-INF/views/memo/update.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int searchNo = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = """
					UPDATE
						memo
					SET
						title = ?,
						content = ?,
						writer = ?,
					WHERE
						no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, content);
			statement.setString(3, writer);
			statement.setInt(4, searchNo);

			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				resp.sendRedirect(req.getContextPath() + "/memos");
			} else {
				req.getRequestDispatcher("/WEB-INF/views/memo/list.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
