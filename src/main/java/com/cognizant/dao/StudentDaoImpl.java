package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	//private JdbcTemplate  jdbcTemplate;

	private List<Student> list = new ArrayList<Student>();

	@Override
	public String insert(Student student) {

		if (list.add(student))
			return "SUCCESS";
		else
			return "FAIL";

	}

	@Override
	public String delete(Student student) {

		return null;
	}

	@Override
	public String update(Student student) {
		return null;
	}

	@Override
	public List<Student> getAll() {
		return list;
	}

}
