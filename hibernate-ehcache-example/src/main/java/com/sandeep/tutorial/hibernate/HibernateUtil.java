package com.sandeep.tutorial.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.sandeep.tutorial.hibernate.entity.onetoone.Person;

/**
 * @author imssbora
 */
public class HibernateUtil {

   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
            StandardServiceRegistryBuilder registryBuilder = 
                  new StandardServiceRegistryBuilder();

            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sandeepdb");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "Sandeep@1");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
            // Enable second level cache
           // settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
            settings.put(Environment.USE_QUERY_CACHE, true);
            // Specify cache region factory class
            settings.put(Environment.CACHE_REGION_FACTORY, 
                  "org.hibernate.cache.jcache.JCacheRegionFactory");
            
            // Specify cache provider
            settings.put("hibernate.javax.cache.provider", 
                  "org.ehcache.jsr107.EhcacheCachingProvider");

            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            MetadataSources sources = new MetadataSources(registry)
                  .addAnnotatedClass(Person.class);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }

   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
