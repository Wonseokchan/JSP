package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "select no, depart, name, address, phone from student";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			List<StudentVO> list = new ArrayList<StudentVO>();
			while (resultSet.next()) {
				String no = resultSet.getString("no");
				String email = resultSet.getString("depart");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String phone = resultSet.getString("phone");

				list.add(new StudentVO(no, email, name, address, phone));
			}
			req.setAttribute("students", list);
			req.getRequestDispatcher("/WEB-INF/views/students/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
