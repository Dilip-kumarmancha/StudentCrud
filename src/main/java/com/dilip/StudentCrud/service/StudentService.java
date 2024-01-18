package com.dilip.StudentCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dilip.StudentCrud.beans.Student;
import com.dilip.StudentCrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentrepo;
      
	@Transactional
	public List<Student> getAll() {
		return studentrepo.findAll();

	}
	
	
	@Transactional
	public Optional<Student> findbyId(int id ) {      // there may be a chance of getting null value for provided id so optional class is used to deal with null pointer exceptions 
		return studentrepo.findById(id);
	}
	
	
     @Transactional
	public boolean deletebyId(int id) {
		if (studentrepo.existsById(id)) {
			studentrepo.deleteById(id);
			return true;
		}
		return false;

	}
	
	
     @Transactional
	public Student updateStudent(int id, Student student) {
		Optional<Student> st = studentrepo.findById(id);
		if (st.isPresent()) {
			Student student1 = st.get();
			student1.setStdname(student.getStdname());
			student1.setAge(student.getAge());
			student1.setBranch(student.getBranch());
			student1.setGmail(student.getGmail());
			return studentrepo.save(student1);

		}
		throw new RuntimeException("Student details not found with id:" + id);
	}
	
	
	
    @Transactional
	public Student insertStudent(Student student) {

		return studentrepo.save(student);
	}

}
