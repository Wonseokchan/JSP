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

@WebServlet("/memos/view")
public class MemoViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchNo = req.getParameter("no");

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
			statement.setString(1, searchNo);

			resultSet = statement.executeQuery();
			MemoVO memo = null;
			while (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date registerDate = resultSet.getDate("register_date");
				Date modifiedDate = resultSet.getDate("modified_date");
				memo = new MemoVO(no, title, content, writer, registerDate.toLocalDate(), modifiedDate.toLocalDate());
			}
			req.setAttribute("memo", memo);
			req.getRequestDispatcher("/WEB-INF/views/memo/view.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
