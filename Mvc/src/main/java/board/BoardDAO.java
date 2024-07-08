package board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public List<BoardVO> selectBoards() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<BoardVO> board = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = """
					SELECT
						no,
						title,
						content,
						writer,
						hits,
						register_date,
						modified_date
					FROM
						board
					""";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			board = new ArrayList<BoardVO>();
			while (resultSet.next()) {
				long no = resultSet.getLong("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				int hits = resultSet.getInt("hits");
				Date registerDate = resultSet.getDate("register_date");
				Date modifiedDate = resultSet.getDate("modified_date");
				board.add(new BoardVO(no, title, content, writer, hits, registerDate.toLocalDate(), modifiedDate));

			}
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
		return board;
	}

	public BoardVO selectBoard(long searchno) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		BoardVO board = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "SELECT no, title, content, writer, register_date, modified_date, hits FROM board WHERE no = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, searchno);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				long no = resultSet.getLong("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date registerDate = resultSet.getDate("register_date");
				Date modifiedDate = resultSet.getDate("modified_date");
				int hits = resultSet.getInt("hits");
				board = new BoardVO(no, title, content, writer, hits, registerDate.toLocalDate(), modifiedDate);
			}
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
		return board;
	}

	public int registerBoard(BoardVO board) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");

			String sql = "INSERT INTO board (title, content, writer) VALUES( ?,?,? )";
			statement = connection.prepareStatement(sql);
			statement.setString(1, board.getTitle());
			statement.setString(2, board.getContent());
			statement.setString(3, board.getWriter());

			executeUpdate = statement.executeUpdate();

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
		return executeUpdate;
	}

	public int modifyBoard(BoardVO board) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "UPDATE board SET title = ?, content = ?, writer = ?, modified_date = sysdate WHERE no = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, board.getTitle());
			statement.setString(2, board.getContent());
			statement.setString(3, board.getWriter());
			statement.setLong(4, board.getNo());

			executeUpdate = statement.executeUpdate();
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
		return executeUpdate;
	}

	public int removeBoard(long no) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std306", "oracle21c");
			String sql = "DELETE FROM board WHERE no = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, no);

			executeUpdate = statement.executeUpdate();
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
		return executeUpdate;
	}
}
