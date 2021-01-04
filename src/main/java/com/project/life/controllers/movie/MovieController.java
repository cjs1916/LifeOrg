package com.project.life.controllers.movie;

import java.util.List; 

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.life.models.movie.Movie;
import com.project.life.models.user.User;
import com.project.life.services.movie.MovieService;
import com.project.life.services.user.UserService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;
	private final UserService userService;

	public MovieController(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
	}

	@RequestMapping("")
	public String movie(@ModelAttribute("movie") Movie movie, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		List<Movie> movies = user.getMovies();
		Boolean isEmpty = movies.isEmpty();
		System.out.println(movies.isEmpty());
		model.addAttribute("isEmpty", isEmpty);
		model.addAttribute("movies", movies);
		return "movie/my_movies.jsp";
	}

	@RequestMapping("/details")
	public String movieDetails(@ModelAttribute("movie") Movie movie, BindingResult result,HttpSession session,Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		List<Movie> movies = user.getMovies();
		Boolean isFavorited=false;
		for( int i=0;i<movies.size();i++) {
			if(movies.get(i)==movie) {
					isFavorited = true;
			}
		}
		model.addAttribute("isFavorited", isFavorited);
			return "movie/movie_details.jsp";
	}

	@RequestMapping(value = "/favorite", method = RequestMethod.POST)
	public String favorite(@ModelAttribute("movie") Movie movie, HttpSession session,@RequestParam("title") String title, @RequestParam("releaseDate")String releaseDate,@RequestParam("rating") String rating,@RequestParam("poster")String poster,@RequestParam("imdbId") String imdbId) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		movieService.saveMovie(movie);
		List<Movie> movies = user.getMovies();
		movies.add(movie);
		user.setMovies(movies);
		userService.saveUser(user);
		return "redirect:/movies";
	}
	
	@GetMapping("/unfavorite/{id}")
	public String unfavorite(@ModelAttribute("movie") Movie movie, @PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		Movie m = movieService.findMovieById(id);
		List<Movie> movies = user.getMovies();
		movies.remove(m);
//		movieService.deleteMovie(m);
		user.setMovies(movies);
		userService.saveUser(user);
		return "redirect:/movies";
	}

	
}