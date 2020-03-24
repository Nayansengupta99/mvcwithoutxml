package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
@Qualifier("StudentDao")
public class StudentDaoImpl implements StudentDao {
	
	
    @Autowired

	private JdbcTemplate  jdbcTemplate;

	
	
	
	
	private List<Student> list = new ArrayList<Student>();

	@Override
	public String insert(Student s) {
		int row = jdbcTemplate.update("INSERT INTO student VALUES(?, ?)", s.getId(), s.getName());
		if (list.add(s))
			return "SUCCESS";
		else
			return "FAIL";

	}

	@Override
	public String delete(Student s) {
		String sql = "delete from student where id=?";
		int result = jdbcTemplate.update(sql, s.getId());
		String flag="Deletion Failure";
		int i=0;
		for(Student st:list)
		{
			
			if(st.getId()==s.getId())
			{
				list.remove(i);
				flag="Deletion Successful";
				break;
			}
			i++;
		}
		return flag;
	}

	@Override
	public String update(Student s) {
		String sql = "update student set name=? where id=?";
		int result = jdbcTemplate.update(sql, s.getName(),s.getId());
		
		
		
		
		String flag=" ";
		for(Student st:list)
		{
			if(st.getId()==s.getId())
			{
				st.setName(s.getName());
				flag="Success";
			}
			else
			{
				flag="Fail";
			}
		}
		return flag;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> students = jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				
				return student;
			}});
		return students;
	}

}
