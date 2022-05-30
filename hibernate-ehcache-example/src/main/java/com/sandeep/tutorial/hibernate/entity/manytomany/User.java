package com.sandeep.tutorial.hibernate.entity.manytomany;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="user")
@Cache(region = "userCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class User {
	@Id
	private Integer userId;

    private String userName;
    private String userPwd;
    
    @ManyToMany(mappedBy="users", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private List<Role> roles;
    
    @Column(name = "user_id")
     public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "user_pwd")
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Column(name = "role")
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", roles=" + roles + "]";
	}

	
     
     
}
