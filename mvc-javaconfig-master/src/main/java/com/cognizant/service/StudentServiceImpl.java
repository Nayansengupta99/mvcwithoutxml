package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String insert(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public String delete(Student student) {
		return studentDao.delete(student);
	}

	@Override
	public String update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

}
