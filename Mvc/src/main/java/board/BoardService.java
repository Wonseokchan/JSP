package board;

import java.util.List;

public class BoardService {
	private BoardDAO dao;

	public BoardService() {
		this.dao = new BoardDAO();
	}

	public List<BoardVO> selectBoards() {
		return dao.selectBoards();
	}

	public BoardVO selectBoard(long searchno) {
		return dao.selectBoard(searchno);
	}

	public int registerBoard(BoardVO board) {
		return dao.registerBoard(board);
	}

	public int modifyBoard(BoardVO board) {
		return dao.modifyBoard(board);
	}

	public int removeBoard(long no) {
		return dao.removeBoard(no);
	}
}
