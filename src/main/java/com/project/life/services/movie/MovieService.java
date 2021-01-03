package com.project.life.services.movie;

import java.util.List; 
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.life.models.movie.Movie;
import com.project.life.models.user.User;
import com.project.life.repositories.movie.MovieRepository;
import com.project.life.repositories.user.UserRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);

	}

	public Movie findMovieById(Long id) {
		Optional<Movie> m = movieRepository.findById(id);

		if (m.isPresent()) {
			return m.get();
		} else {
			return null;
		}
	}

	public List<Movie> getAll() {
		List <Movie> movies = movieRepository.findAll();
		return movies;
	}

}