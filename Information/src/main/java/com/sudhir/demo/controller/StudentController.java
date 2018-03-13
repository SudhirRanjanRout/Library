package com.sudhir.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.demo.dto.StudentDto;
import com.sudhir.demo.repository.StudentRepository;
import com.sudhir.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping(path = "/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
		return new ResponseEntity<>(this.studentService.addStudent(studentDto),HttpStatus.OK);
	}
}
