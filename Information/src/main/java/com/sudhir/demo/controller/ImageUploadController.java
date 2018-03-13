package com.sudhir.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.sudhir.demo.dto.ImageDto;
import com.sudhir.demo.service.BookService;
import com.sudhir.demo.service.ImageUploadService;
@RestController
@RequestMapping("/image")
public class ImageUploadController {
	//private static String uploadedFolder = "C:/Users/Sudhir.Rout/ApplicationDataHouse/";
	
	@Autowired
	ImageUploadService service;
	
	@Autowired
	private BookService userService;
	
	@Autowired
	private Environment env;
	
	List<String> files = new ArrayList<String>();
	
	

	@PostMapping("/uploadImage")
	public ResponseEntity<String> handleFileUpload(@ModelAttribute ImageDto dto) {
		String message = "";
		//String fileInfo = "";
		MultipartFile file = dto.getFile();
		if (file.isEmpty()) {
			message = "Invalid File";
		}
		try {
			String filename = file.getOriginalFilename();
			String directory = env.getProperty("upload.file.path");
			String uploadFilePath = Paths.get("." + File.separator + directory, filename).toString();
			final BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadFilePath)));
            stream.write(file.getBytes());
            service.saveImages(uploadFilePath);
            message = "You successfully uploaded " + filename + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
		
}
