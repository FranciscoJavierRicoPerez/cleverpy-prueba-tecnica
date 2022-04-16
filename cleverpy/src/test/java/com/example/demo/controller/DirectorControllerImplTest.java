package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.demo.service.DirectorService;
import com.example.demo.vo.DirectorVO;

@SpringBootTest
public class DirectorControllerImplTest {
	@InjectMocks
	private DirectorControllerImpl directorController;

	@Mock
	private DirectorService directorService;
	
	@Test
	void createDirectorTest() {
		DirectorVO d = new DirectorVO();
		d.setName("Juan");
		assertEquals(HttpStatus.OK, directorController.createDirector(d).getStatusCode());
	}
	
	@Test
	void findAllMoviesTest() {
		
	}
}
