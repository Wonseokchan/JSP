package student;

public class StudentVO {
	private String no;
	private String department;
	private String name;
	private String address;
	private String phone;

	public StudentVO() {
	}

	public StudentVO(String no, String department, String name, String address, String phone) {
		this.no = no;
		this.department = department;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StudentVO [no=" + no + ", department=" + department + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
