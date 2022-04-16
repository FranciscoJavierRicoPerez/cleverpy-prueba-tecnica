package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Director;
import com.example.demo.repository.DirectorRepository;
import com.example.demo.vo.DirectorVO;


@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorRepository directorRepository;
	
	@Override
	public void createDirector(DirectorVO director) {
		if(null != director) {
			Director d = new Director();
			d.setName(director.getName());
			directorRepository.save(d);
		}
	}

}
