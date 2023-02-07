package com.app.dao;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
	public List<Movie> findMoviesByReleaseYear(int year);

//@Query("select u from Movie u where u.mainProduction= :country")
//public List<Movie> findMoviesByMainProduction(@Param("country") String main_production);
	// specific types of movies
	public List<Movie> findByMainGenre(String mainGenre);

	// specific country's production
	public List<Movie> findByMainProduction(String mainProduction);

	// specific type of movie of specific country.
	public List<Movie> findByMainProductionAndMainGenre(String mainProduction, String mainGenre);

	//less than number of minutes(sorting acc. to duration)
	public List<Movie> findByDurationLessThan(int duration);
	
	// greater than number of minutes
	public List<Movie> findByDurationGreaterThan(int duration);
	
	// mostly viewed movies acc. to votes
	public List<Movie> findByVotesGreaterThan(int votes);
	
	//pagination it will return 10 records of specific type of movie
	public List<Movie> findFirst10ByMainGenre(String mainGenre);
	
	
	
	
}
