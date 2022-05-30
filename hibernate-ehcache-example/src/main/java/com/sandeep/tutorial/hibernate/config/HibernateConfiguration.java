package com.sandeep.tutorial.hibernate.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.Environment;

public class HibernateConfiguration {

	
	public static Map<String, Object> getSettings()
	{
		Map<String, Object> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sandeepdb");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Sandeep@1");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        // Enable second level cache
        settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);//if we make it false then USE_QUERY_CACHE will not work but if we comment it then USE_QUERY_CACHE will work
        settings.put(Environment.USE_QUERY_CACHE, true);
        // Specify cache region factory class
        settings.put(Environment.CACHE_REGION_FACTORY, 
              "org.hibernate.cache.jcache.JCacheRegionFactory");
        
        // Specify cache provider
        settings.put("hibernate.javax.cache.provider", 
              "org.ehcache.jsr107.EhcacheCachingProvider");
        
        return settings;
	}

}
