package com.springjdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	
	public static void main(String[] args) {
    System.out.println("Application started...........");
    AbstractApplicationContext context= new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
    JdbcTemplate template = context.getBean("jdbctemplate",JdbcTemplate.class);
//   insert query
    String query="insert into student(id,name,city) values(?,?,?)";
    int result=template.update(query,101,"Riya Majumder","Harinchawra");
    System.out.println("number of rows of updated : "+result);
    
  }
}
