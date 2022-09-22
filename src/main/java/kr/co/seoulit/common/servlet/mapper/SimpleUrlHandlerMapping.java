package kr.co.seoulit.common.servlet.mapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import kr.co.seoulit.common.servlet.context.ApplicationContext;
import kr.co.seoulit.common.servlet.mvc.Controller;

public class SimpleUrlHandlerMapping {
	private HashMap<String,String> map;
	private static SimpleUrlHandlerMapping instance;
	public static SimpleUrlHandlerMapping getInstance(ServletContext application) {
		// TODO Auto-generated method stub
		if(instance==null) instance=new SimpleUrlHandlerMapping(application);
		return instance;
	}
	private SimpleUrlHandlerMapping(ServletContext application){
		map=new HashMap<String,String>();
		String path=application.getInitParameter("urlmappingFile");
		String rPath=application.getRealPath(path);
		Properties properties=new Properties();
		try {
			properties.load(new FileReader(rPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> set=properties.stringPropertyNames();
		for(String key: set){
			String value=properties.getProperty(key);
			map.put(key.trim(),value.trim());
		}
	}
	public Controller getController(ApplicationContext applicationContext, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		String contextPath=request.getContextPath();
		int sIndex=contextPath.length(); 
		String key=uri.substring(sIndex);
		System.out.println(key);
		String beanName=map.get(key);
		return (Controller)(applicationContext.getBean(beanName));
	}
}
