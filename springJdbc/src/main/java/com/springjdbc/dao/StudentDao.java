package com.springjdbc.dao;

import com.springjdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);

	public int update(Student student);

	public int delete(int studentId);

	public Student getStudent(int studentId);

}
