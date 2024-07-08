package memo;

import java.time.LocalDate;

public class MemoVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private LocalDate registerDate;
	private LocalDate modifiedDate;

	public MemoVO() {

	}

	public MemoVO(int no, String title, String content, String writer, LocalDate registerDate, LocalDate modifiedDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
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

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "MemoVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", registerDate=" + registerDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
