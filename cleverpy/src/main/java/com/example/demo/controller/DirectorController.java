package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.vo.DirectorVO;

public interface DirectorController {
	@PostMapping("/create")
	public ResponseEntity<?> createDirector(@RequestBody DirectorVO director);
}
