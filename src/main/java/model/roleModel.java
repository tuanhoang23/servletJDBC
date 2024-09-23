package model;

public class roleModel extends abstractModel<roleModel> {
	
	private String nameRole;
	private long userId;
	private String codeRole;
	
	public roleModel() {
		super();
	}
	
	public roleModel(String nameRole, long userId, String codeRole) {
		super();
		this.nameRole = nameRole;
		this.userId = userId;
		this.codeRole = codeRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCodeRole() {
		return codeRole;
	}

	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}
	
}
