package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Movie;
import com.app.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;

	@ResponseBody
	@GetMapping("/")
	public String mainPage() {
		return "Welcome to our API";
	}

	@ResponseBody
	@PostMapping(path = "/movies")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		System.out.println("Saving record into database....");
		try {
			Movie savedMovie = service.saveMovie(movie);
			return ResponseEntity.status(HttpStatus.OK).body(savedMovie);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping(path = "/movies/year/{year}")
	public ResponseEntity<List<Movie>> getAllMoviesOfYear(@PathVariable("year") int year) {
		try {
			List<Movie> list = service.getMovieByReleaseYear(year);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllBooks()
	{
		try
		{

			List<Movie> list=service.getAllMovies();
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@ResponseBody
	@GetMapping("/movies/country/{country}")
	public ResponseEntity<List<Movie>> getAllMoviesOfCountry(@PathVariable String country) {
		try {
			List<Movie> list = service.getMoviesOfCountry(country);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/type/{type}")
	public ResponseEntity<List<Movie>> getMoviesOfType(@PathVariable("type") String type) {
		try {

			List<Movie> list = service.getMoviesOfType(type);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/duration/{duration}")
	public ResponseEntity<List<Movie>> getMoviesOfDurationLesserThan(@PathVariable("duration") int duration) {
		try {

			List<Movie> list = service.getMoviesOfDurationLessThan(duration);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/durationbig/{duration}")
	public ResponseEntity<List<Movie>> getMoviesOfDurationGreaterThan(@PathVariable("duration") int duration) {
		try {

			List<Movie> list = service.getMoviesOfDurationGreaterThan(duration);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/country/{country}/type/{type}")
	public ResponseEntity<List<Movie>> getMoviesOfCountryAndType(@PathVariable("country") String country,
			@PathVariable("type") String type) {
		try {

			List<Movie> list = service.getMoviesOfCountryAndType(country, type);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/votes/{votes}")
	public ResponseEntity<List<Movie>> getMoviesOfVotesHigher(@PathVariable("votes") int votes) {
		try {

			List<Movie> list = service.getMoviesOfVotesGreaterThan(votes);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@ResponseBody
	@GetMapping("/movies/first10/{type}")
	public ResponseEntity<List<Movie>> getFirst10OfType(@PathVariable("type") String type) {
		try {

			List<Movie> list = service.getFirst10RecordsOfType(type);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
