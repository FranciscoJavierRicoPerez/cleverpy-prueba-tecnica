package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Director;
import com.example.demo.entity.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.DirectorRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.vo.ActorVO;
import com.example.demo.vo.DirectorVO;
import com.example.demo.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired 
	private DirectorRepository directorRepository;
	
	@Override
	public void createMovie(MovieVO movie) {
		if(null != movie) {
			Movie m = new Movie();
			m.setTitle(movie.getTitle());
			m.setRelaseDate(movie.getRelaseDate());
			m.setActors(getActors(movie));
			m.setDirectors(getDirectors(movie));
			movieRepository.save(m);
		}
	}
	
	private Set<Actor> getActors(MovieVO movie){
		Set<Actor> actors = new HashSet<>();
		for(ActorVO actor: movie.getActors()) {
			Actor a = actorRepository.findByName(actor.getName()).get();
			actors.add(a);
		}
		return actors;
	}
	
	private Set<Director> getDirectors(MovieVO movie){
		Set<Director> directors = new HashSet<>();
		for(DirectorVO director: movie.getDirectors()) {
			Director d = directorRepository.findByName(director.getName()).get();
			directors.add(d);
		}
		return directors;
	}

	@Override
	public Page findAllMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}

	@Override
	public MovieVO findByTitle(String title) {
		Movie m = new Movie();
		m = movieRepository.findByTitle(title);
		MovieVO mvo = new MovieVO();
		mvo.setTitle(m.getTitle());
		mvo.setRelaseDate(m.getRelaseDate());
		Set<ActorVO> actors = new HashSet<>();
		for(Actor a : m.getActors()) {
			ActorVO avo = new ActorVO();
			avo.setName(a.getName());
			actors.add(avo);
		}
		mvo.setActors(actors);
		Set<DirectorVO> directors = new HashSet<>();
		for(Director d : m.getDirectors()) {
			DirectorVO dvo = new DirectorVO();
			dvo.setName(d.getName());
			directors.add(dvo);
		}
		mvo.setDirectors(directors);
		return mvo;
	}
}
