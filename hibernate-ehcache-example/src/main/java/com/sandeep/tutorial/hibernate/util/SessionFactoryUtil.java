package com.sandeep.tutorial.hibernate.util;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sandeep.tutorial.hibernate.config.HibernateConfiguration;
import com.sandeep.tutorial.hibernate.entity.manytomany.Role;
import com.sandeep.tutorial.hibernate.entity.manytomany.User;
import com.sandeep.tutorial.hibernate.entity.onetoone.Address;
import com.sandeep.tutorial.hibernate.entity.onetoone.Person;

public class SessionFactoryUtil {

	private SessionFactory factory;
	private static StandardServiceRegistry registry;
	
	private SessionFactoryUtil()
	{
		try 
		{
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
			registryBuilder.applySettings(HibernateConfiguration.getSettings());
			registry = registryBuilder.build();
			MetadataSources sources = new MetadataSources(registry);
			addEntityClassesMetadataSources(sources);		
			Metadata metadata = sources.getMetadataBuilder().build();
			factory = metadata.getSessionFactoryBuilder().build();
		}
		catch (Exception e) {
            shutdown();
            e.printStackTrace();
         }
		
	}
	public static SessionFactory getSessionFactory()
	{
		return LAZY_LOADER.INSTANCE.factory;
	}
	
	public static final class LAZY_LOADER
	{
		private static final SessionFactoryUtil INSTANCE = new SessionFactoryUtil();
	}
	
	public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
	
	public static void addEntityClassesMetadataSources(MetadataSources sources)
	{
		getClasses().forEach(e -> sources.addAnnotatedClass((Class) e));
	}
	
	
	public static List<Object> getClasses()
	{
		return Arrays.asList(Person.class, Address.class, User.class, Role.class);
	}
}
