package com.infosys.studentmanage.teacher.model;

public class UserDTO {
	
	
    private long id;
    private String userName;
    private String password;
    private long roleId;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getuserName() {
		return userName;
	}

	public void setMemberName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", roleId="
				+ roleId + "]";
	}

}
