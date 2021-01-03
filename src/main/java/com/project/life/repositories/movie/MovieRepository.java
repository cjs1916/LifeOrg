package com.project.life.repositories.movie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.life.models.movie.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	List<Movie> findAll();
	
}
