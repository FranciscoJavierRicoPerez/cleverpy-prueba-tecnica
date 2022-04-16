package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.vo.MovieVO;

public interface MovieController {
	
	@PostMapping("/create")
	public ResponseEntity<?> createMovie(@RequestBody MovieVO movie);
	
	@GetMapping("/all")
	public  ResponseEntity<Page> findAllMovies(Pageable pageable);
	
	@GetMapping("/byTitle")
	public ResponseEntity<MovieVO> findByTitle(@RequestParam("title") String title);
	
}
