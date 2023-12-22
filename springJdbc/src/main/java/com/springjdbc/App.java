package com.springjdbc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

public class App {
	
	public static void main(String[] args) {
    System.out.println("Application started...........");
    AbstractApplicationContext context= new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
    StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    
    Student student= new Student();
    student.setId(105);
    student.setName("Pratim Sarkar");
    student.setCity("Jaytara");
    
    //inserting data
//    int insert = studentDao.insert(student);
//    System.out.println("number of rows inserted :"+insert);
    
    //updating data
//    int update=studentDao.update(student);
//    System.out.println("number of rows changed: "+update);
    
    //deleting data
//    int delete = studentDao.delete(105);
//    System.out.println("number of rows deleted: "+delete);
    
    //selecting data from database
    Student s=studentDao.getStudent(101);
    System.out.println("getting student is : "+s);
    
    
    context.close();
    
  }
}
