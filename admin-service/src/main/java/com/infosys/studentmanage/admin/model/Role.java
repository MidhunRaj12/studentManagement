package com.infosys.studentmanage.admin.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    private long roleId;
    
    @Column(name = "role_name")
    private String roleName;
	public long getRoleId() {
		return roleId;
	}
	
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	

	public String getRoleName() {
		return roleName;
	}
	

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
    

    
}
