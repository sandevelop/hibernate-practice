package com.sandeep.tutorial.hibernate.helper;

import org.hibernate.Session;

import com.sandeep.tutorial.hibernate.entity.manytomany.Role;
import com.sandeep.tutorial.hibernate.entity.manytomany.User;

public class ManyToManyHelper {

	public static void save(Session session) {
		Populate.populateRole(session);
		Populate.populateUser(session);
		
	}

	public static void update(Session session) {

	}

	public static void get(Session session) {
		User u1 = session.get(User.class, 1);
        System.out.println(u1);
	}

	public static void delete(Session session) {
		session.delete(session.get(Role.class, 2));
		//session.delete(session.get(User.class, 9));
	}
}
