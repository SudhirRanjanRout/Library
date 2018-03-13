package com.sudhir.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sudhir.demo.domain.Book;
import com.sudhir.demo.domain.Images;
import com.sudhir.demo.repository.BookRepository;
import com.sudhir.demo.repository.ImageDao;

@Service
public class ImageUploadService {
	
	private final Path rootLocation = Paths.get("upload-dir");
	@Autowired
	private ImageDao dao;
	
	@Autowired 
	private BookRepository userRepository;
	
	

	public void saveImages(String uploadFilePath) {
		String fileId = UUID.randomUUID().toString();
		
		//Storing the data into database
		Images image = dao.save(new Images( uploadFilePath, fileId.split("-")[0]));
		//Book books = userRepository.findByCallNo(callNo);
		//String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		//User user = userRepository.findByUsername(userName);
		//set the foreign key in user table
		//user.setImages(image);
		//userRepository.save(user);
		
	}

	public List<Images> getAll() {
		return dao.findAll();
	}

	public String getSaveFilePathByUser(int id) {
		return dao.findOne(id).getFileStoredPath();
	}
	
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}
	
	}
