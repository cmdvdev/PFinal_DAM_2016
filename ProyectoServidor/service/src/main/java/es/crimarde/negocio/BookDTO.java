package es.crimarde.negocio;

public class EmployeeDTO {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDTO(EmployeeDTOBuilder builder) {
		this.id = builder.getId();
		this.firstName = builder.getFirstName();
		this.lastName = builder.getLastName();
		this.email = builder.getEmail();
		this.phone = builder.getPhone();
	}

	
	public EmployeeDTO(String firstName, String lastName, String email,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public EmployeeDTO(long id, String firstName, String lastName, String email,
			String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}