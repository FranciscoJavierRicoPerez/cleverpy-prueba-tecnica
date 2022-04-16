package com.example.demo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MovieService;
import com.example.demo.vo.MovieVO;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieControllerImpl implements MovieController{

	private final static Logger logger = LoggerFactory.getLogger(MovieControllerImpl.class);
	
	@Autowired
	private MovieService movieService;
	
	@Override
	@PostMapping("/create")
	public ResponseEntity<?> createMovie(MovieVO movie) {
		logger.info("Creating a new movie...");
		movieService.createMovie(movie);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	@GetMapping("/all")
	public ResponseEntity<Page> findAllMovies(Pageable pageable) {
		return new ResponseEntity<>(movieService.findAllMovies(pageable), HttpStatus.OK);
	}

	@Override
	@GetMapping("/byTitle")
	public ResponseEntity<MovieVO> findByTitle(@RequestParam("title") String title) {
		return new ResponseEntity<>(movieService.findByTitle(title), HttpStatus.OK);
	}
	
	

}
