package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		// inserting data
		String query="insert into student(id,name,city) values(?,?,?)";
		int update = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
		return update;
	}

	@Override
	public int update(Student student) {
		// updating existing data
		String query="update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return update;
	}
	@Override
	public Student getStudent(int studentId) {
		// selecting single student data
		String query="select * from student where id=?";
		RowMapper<Student> rowMaper=new RowMaperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, 
			//anonymous class
		   new RowMapper<Student>(){
			// using anonymous class we can do the same work 
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));

				return student;
			}
			
		},studentId);
		return student;
	}

	@Override
	public int delete(int studentId) {
		// deleting the value
		String query="delete from student where id=?";
		int update = this.jdbcTemplate.update(query,studentId);
		return update;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	

}
