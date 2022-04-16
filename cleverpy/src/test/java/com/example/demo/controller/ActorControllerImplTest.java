package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.demo.service.ActorService;
import com.example.demo.vo.ActorVO;

@SpringBootTest
public class ActorControllerImplTest {
	
	@InjectMocks
	private ActorControllerImpl actorController;
	
	@Mock
	private ActorService actorService;
	
	@Test
	void createActorTest() {
		ActorVO a = new ActorVO();
		a.setName("Juan");
		assertEquals(HttpStatus.OK, actorController.createActor(a).getStatusCode());
	}
}
