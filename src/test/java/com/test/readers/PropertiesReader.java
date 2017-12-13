package com.test.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
	private final Properties configProp = new Properties();
	   
	   public PropertiesReader()
	   {
	      InputStream in = this.getClass().getClassLoader().getResourceAsStream("environments/"+System.getProperty("env"));
	      System.out.println("Read all properties from file");
	      try {
	          configProp.load(in);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	   }

	   private static class LazyHolder
	   {
	      private static final PropertiesReader INSTANCE = new PropertiesReader();
	   }

	   public static PropertiesReader getInstance()
	   {
	      return LazyHolder.INSTANCE;
	   }
	   
	   public String getProperty(String key){
	      return configProp.getProperty(key);
	   }
	   
	   public Set<String> getAllPropertyNames(){
	      return configProp.stringPropertyNames();
	   }
	   
	   public boolean containsKey(String key){
	      return configProp.containsKey(key);
	   }
}
