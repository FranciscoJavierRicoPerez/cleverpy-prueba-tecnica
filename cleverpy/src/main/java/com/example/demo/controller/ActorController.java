package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.vo.ActorVO;

public interface ActorController {

	@PostMapping("/create")
	public ResponseEntity<?> createActor(@RequestBody ActorVO actor);
	
}
