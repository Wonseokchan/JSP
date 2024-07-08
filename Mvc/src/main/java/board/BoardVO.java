package board;

import java.time.LocalDate;
import java.util.Date;

public class BoardVO {
	private long no;
	private String title;
	private String content;
	private String writer;
	private int hits;
	private LocalDate registerDate;
	private Date modifiedDate;

	public BoardVO() {
	}

	public BoardVO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVO(long no, String title, String content, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVO(long no, String title, String content, String writer, int hits, LocalDate registerDate,
			Date modifiedDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hits="
				+ hits + ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
