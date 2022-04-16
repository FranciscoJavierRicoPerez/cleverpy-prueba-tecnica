package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.vo.MovieVO;

public interface MovieService {
	void createMovie(MovieVO movie);
	
	Page findAllMovies(Pageable pageable);
	
	MovieVO findByTitle(String title);
}
