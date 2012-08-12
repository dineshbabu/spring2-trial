package com.springinaction.chapter05.database.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRantDao{
	
  private static JdbcTemplate jdbcTemplate;
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  	private static final String INSERT = "insert into dinesh_test (a, b) values (??)";
	public static void insertRow() {
	  jdbcTemplate.update(INSERT, new Object[] { 1, "hello" });
	}
	
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\springinaction\\chapter05\\database\\jdbc\\spring-idol.xml");
		JdbcRantDao jdbcRantDao = (JdbcRantDao)context.getBean("rantDao");
		
		jdbcRantDao.insertRow();
	}
}