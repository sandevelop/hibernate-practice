package com.sandeep.tutorial.hibernate.helper;

import org.hibernate.Session;

import com.sandeep.tutorial.hibernate.entity.onetoone.Address;
import com.sandeep.tutorial.hibernate.entity.onetoone.Person;

public class OneToOneHelper {

	
	public static void save(Session session) {
		
		Person p1 = new Person();
		p1.setName("Sandeep");
		//p1.setAddress(address);
		
		Person p2 = new Person();
		p2.setName("Deepak");
		//p2.setAddress(address2);
		
		Address address = new Address();
		address.setArea("Baner");
		address.setCity("Pune");
		address.setState("MH");
		address.setPerson(p1);
		
		Address address2 = new Address();
		address2.setArea("Raiganj");
		address2.setCity("Gorakhpur");
		address2.setState("UP");
		address2.setPerson(p2);
		
		
		session.save(p1);
		session.save(address);
		
		//session.save(p2);
		//session.save(address2);
		
		
	}

	public static void update(Session session) {
		Person p = session.get(Person.class, 2l);
		p.setName("Mandeep");
		session.update(p);
		System.out.println("updated");
	}

	public static void get(Session session) {
		System.out.println(session.get(Person.class, 2l));;
		
	}

	public static void delete(Session session) {
		System.out.println("deleting person sandeep");
		session.delete(session.get(Person.class, 2l));
		System.out.println("deleted person sandeep");
	}
}
