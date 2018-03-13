package com.sudhir.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.demo.domain.Student;
import com.sudhir.demo.dto.StudentDto;
import com.sudhir.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public String addStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
		if(studentDto != null) {
			Student student = new Student();
			BeanUtils.copyProperties(studentDto, student);
			studentRepository.save(student);
			return"student added successfully";
		}
		return null;
	}

}
