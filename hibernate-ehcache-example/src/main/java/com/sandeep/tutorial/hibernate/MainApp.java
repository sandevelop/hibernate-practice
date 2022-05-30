package com.sandeep.tutorial.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sandeep.tutorial.hibernate.entity.manytomany.Role;
import com.sandeep.tutorial.hibernate.entity.manytomany.User;
import com.sandeep.tutorial.hibernate.entity.onetoone.Person;
import com.sandeep.tutorial.hibernate.helper.ManyToManyHelper;
import com.sandeep.tutorial.hibernate.helper.OneToOneHelper;
import com.sandeep.tutorial.hibernate.util.SessionFactoryUtil;

/**
 * @author imssbora
 */
public class MainApp {

   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      try {
        
    	 session = SessionFactoryUtil.getSessionFactory().openSession();
         transaction = session.getTransaction();
         transaction.begin();
       
         //Person person=session.get(Person.class, 41L);
         //Person person=(Person) se ssion.createQuery("from Person where id = 41").setCacheable(true).uniqueResult();
         //System.out.println(person);
         ManyToManyHelper.save(session);
         ManyToManyHelper.get(session);
        // ManyToManyHelper.delete(session);
         transaction.commit();
         session.close();
         
         session = SessionFactoryUtil.getSessionFactory().openSession();
         transaction = session.getTransaction();
         transaction.begin();
         
         ManyToManyHelper.get(session);

         //Person person2=session.get(Person.class, 41L);
         //Person person2=(Person) session.createQuery("from Person where id = 41").setCacheable(true).uniqueResult();
         //System.out.println(person2);
         
        // OneToOneHelper.save(session);
         //OneToOneHelper.get(session);
         //OneToOneHelper.update(session);
         System.out.println("\n");
        // OneToOneHelper.delete(session);
         transaction.commit();
         session.close();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      
      HibernateUtil.shutdown();
   }
   
   public static void  insert()
   {
	   
   }
}
