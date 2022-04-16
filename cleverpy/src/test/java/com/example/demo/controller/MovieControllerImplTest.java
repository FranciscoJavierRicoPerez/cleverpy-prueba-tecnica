package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import com.example.demo.service.MovieService;
import com.example.demo.vo.MovieVO;

@SpringBootTest
public class MovieControllerImplTest {
	
	@InjectMocks
	private MovieControllerImpl movieController;
	
	@Mock
	private MovieService movieService;
	
	@Test
	void createMovieTest() {
		MovieVO m = new MovieVO();
		assertEquals(HttpStatus.OK, movieController.createMovie(m).getStatusCode());
	}
	
	
	@Test
	void findAllMoviesTest() {
		Page p = null;
		Pageable pageable = null;
		Mockito.when(movieService.findAllMovies(Mockito.any())).thenReturn(p);
		assertEquals(HttpStatus.OK, movieController.findAllMovies(pageable).getStatusCode());
	}
	
	@Test
	void findByTitleTest() {
		Mockito.when(movieService.findByTitle(Mockito.any())).thenReturn(new MovieVO());
		assertEquals(HttpStatus.OK, movieController.findByTitle(Mockito.any()).getStatusCode());
	}
	
}
