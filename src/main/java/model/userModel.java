package model;

public class userModel extends abstractModel<userModel> {
	

	private String userName;
	private String password;
	private String fullName;
	private long role_Id;
	private int status;
	roleModel role = new roleModel();
	
	
	public roleModel getRole() {
		return role;
	}

	public void setRole(roleModel role) {
		this.role = role;
	}

	public userModel() {
		super();
	}

	public userModel(String userName, String password, String fullName, long role_Id, int status) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.role_Id = role_Id;
		this.status = status;
	}





	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public long getRole_Id() {
		return role_Id;
	}


	public void setRole_Id(long role_Id) {
		this.role_Id = role_Id;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
}
