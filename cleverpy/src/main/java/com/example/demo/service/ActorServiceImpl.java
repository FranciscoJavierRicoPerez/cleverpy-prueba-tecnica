package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.vo.ActorVO;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public void createActor(ActorVO actor) {
		if(null != actor) {
			Actor a = new Actor();
			a.setName(actor.getName());
			actorRepository.save(a);
		}
	}
	
}
