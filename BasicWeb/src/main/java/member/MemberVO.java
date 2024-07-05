package member;

import java.time.LocalDate;

//원래는 DTO인데 우리나라는 VO라고 많이 이야기 한다
public class MemberVO {
	private long id;
	private String email;
	private String password;
	private String name;
	private LocalDate registerDate;

	public MemberVO() {

	}

	public MemberVO(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public MemberVO(long id, String email, String password, String name) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public MemberVO(long id, String email, String name, LocalDate registerDate) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.registerDate = registerDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", email=" + email + ", passwrod=" + password + ", name=" + name
				+ ", registerDate=" + registerDate + "]";
	}

}
