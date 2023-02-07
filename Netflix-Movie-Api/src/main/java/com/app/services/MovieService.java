package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.MovieRepo;
import com.app.entities.Movie;

@Component
public class MovieService {
	@Autowired
	MovieRepo repo;
	public Movie saveMovie(Movie movie)
	{
		Movie saved=repo.save(movie);
		System.out.println("Service saved record successfully...");
		return saved;
	}
	public List<Movie> getAllMovies()
	{
	List<Movie> list=repo.findAll();
	return list;
	}
	public List<Movie> getMovieByReleaseYear(int year)
	{
		List<Movie> list=repo.findMoviesByReleaseYear(year);
	return list;
	}
	public List<Movie> getMoviesOfCountry(String country)
	{
		List<Movie> list=repo.findByMainProduction(country);
		return list;
	}
	
	public List<Movie> getMoviesOfType(String type)
	{
		List<Movie> list=repo.findByMainGenre(type);
		return list;
	}
	
	public List<Movie> getMoviesOfDurationLessThan(int minutes)
	{
		return repo.findByDurationLessThan(minutes);
	}
	public List<Movie> getMoviesOfDurationGreaterThan(int minutes)
	{
		return repo.findByDurationGreaterThan(minutes);
	}
	
	public List<Movie> getMoviesOfCountryAndType(String country,String type)
	{
		return repo.findByMainProductionAndMainGenre(country, type);
	}
	
	public List<Movie> getMoviesOfVotesGreaterThan(int votes)
	{
		return repo.findByVotesGreaterThan(votes);
	}
	
	public List<Movie> getFirst10RecordsOfType(String type)
	{
		return repo.findFirst10ByMainGenre(type);
	}
	
}
