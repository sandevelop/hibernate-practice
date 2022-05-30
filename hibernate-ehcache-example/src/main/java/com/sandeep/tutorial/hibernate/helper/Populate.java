package com.sandeep.tutorial.hibernate.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.sandeep.tutorial.hibernate.entity.manytomany.Role;
import com.sandeep.tutorial.hibernate.entity.manytomany.User;

public class Populate {

	static List<String> userNames = Arrays.asList("Sandeep", "Khushboo", "Ravi", "Deepak", "Radhika", "Santosh", "Vaishnavi", "Husain", "Rohit", "Akshay");
	static List<String> roleNames = Arrays.asList("Admin", "BusinessUser", "User");
	static List<Role> roleList = new ArrayList<Role>();
	static List<User> userList = new ArrayList<User>();
	public static void populateUser(Session session)
	{
		
		for(int i = 1; i<= 10; ++i)
		{
			User user =  new User();
			user.setUserId(i);
			user.setUserName(userNames.get(i-1));
			user.setUserPwd(user.getUserName().replaceAll("[aeiouAEIOU]", "\\$")+ i);
			user.setRoles(roleList);
			userList.add(user);
			session.save(user);
			System.out.println(user.getUserName() +" -> "+user.getUserPwd());
		}
	}
	
	public static void populateRole(Session session)
	{
		
		for(int i = 1; i<= roleNames.size(); ++i)
		{
			Role role =  new Role();
			role.setRoleId(i);
			role.setRoleName(roleNames.get(i-1));
			role.setUsers(userList);
			System.out.println(role.getRoleName());
			roleList.add(role);
			session.save(role);
			System.out.println("After save, let's check id: "+role.getRoleId());
		}
	}
}
