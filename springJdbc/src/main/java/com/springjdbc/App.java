package com.springjdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

public class App {
	
	public static void main(String[] args) {
    System.out.println("Application started...........");
    //using xml configuration property
    AbstractApplicationContext context= new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
    StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    
    // using annotation configuration property
    AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(JdbcConfig.class);
    StudentDao bean = context2.getBean("studentDao",StudentDao.class);
    
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
//    Student select=studentDao.getStudent(101);
//    System.out.println("getting student is : "+select);
    
    //getting all students details from database
    List<Student> students=bean.getAllStudent();
    System.out.println(students);
    
    context.close();
    
  }
}
