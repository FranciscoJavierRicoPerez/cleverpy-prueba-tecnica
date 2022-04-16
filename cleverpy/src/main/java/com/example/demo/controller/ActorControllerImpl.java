package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ActorService;
import com.example.demo.vo.ActorVO;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorControllerImpl implements ActorController{
	private final static Logger logger = LoggerFactory.getLogger(ActorControllerImpl.class);
	
	@Autowired
	private ActorService actorService;

	@Override
	public ResponseEntity<?> createActor(ActorVO actor) {
		logger.info("Creating a new actor...");
		actorService.createActor(actor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
