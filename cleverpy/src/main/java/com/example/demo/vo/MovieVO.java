package com.example.demo.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.Actor;

import lombok.Data;
@Data
public class MovieVO {
	private String title;
	
	private Date relaseDate;
	
	private Set<ActorVO> actors = new HashSet<>();
	
	private Set<DirectorVO> directors = new HashSet<>();
}
