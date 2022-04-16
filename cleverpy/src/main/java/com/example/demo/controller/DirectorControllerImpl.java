package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DirectorService;
import com.example.demo.vo.DirectorVO;

@CrossOrigin
@RestController
@RequestMapping("/directors")
public class DirectorControllerImpl implements DirectorController{

	private final static Logger logger = LoggerFactory.getLogger(DirectorControllerImpl.class);

	@Autowired
	private DirectorService directorService;
	
	@Override
	public ResponseEntity<?> createDirector(DirectorVO director) {
		logger.info("Creating a new director...");
		directorService.createDirector(director);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
