package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
	Optional<Actor> findByName(String name);
}
