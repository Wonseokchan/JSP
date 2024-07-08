package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students/update")
public class StudentUpdateServlet extends HttpServlet {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchDept = req.getParameter("depart");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "SELECT no, depart, name, address, phone FROM student WHERE depart = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, searchDept);

			resultSet = statement.executeQuery();
			StudentVO student = null;
			if (resultSet.next()) {
				String no = resultSet.getString("no");
				String depart = resultSet.getString("depart");
				String name = resultSet.getString("name");
				String address = resultSet.getString("address");
				String phone = resultSet.getString("phone");
				student = new StudentVO(no, depart, name, address, phone);
			}
			req.setAttribute("student", student);
			req.getRequestDispatcher("/WEB-INF/views/students/update.jsp").forward(req, resp);
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String updateId = req.getParameter("id");
		String depart = req.getParameter("depart");
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "update student set depart = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, depart);
			statement.setLong(4, Long.parseLong(updateId));

			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				resp.sendRedirect("/students");
			} else {
				req.getRequestDispatcher("/WEB-INF/views/students/update.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
