package com.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query="insert into student(id,name,city) values(?,?,?)";
		int update = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
		return update;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
