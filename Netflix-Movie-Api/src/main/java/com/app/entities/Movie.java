package com.app.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "Movie_Details")
public class Movie {
	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private int id;
	private String title;
	private int releaseYear;
	private int score;
	private int votes;
	private int duration;
	private String mainGenre;
	private String mainProduction;

	
	public Movie() {

	}


	public String getTitle() {
		return title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getScore() {
		return score;
	}

	public int getVotes() {
		return votes;
	}

	public int getDuration() {
		return duration;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getMainGenre() {
		return mainGenre;
	}


	public String getMainProduction() {
		return mainProduction;
	}


	public void setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
	}


	public void setMainProduction(String mainProduction) {
		this.mainProduction = mainProduction;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + ", score=" + score
				+ ", votes=" + votes + ", duration=" + duration + ", main_genre=" + mainGenre + ", main_production="
				+ mainProduction + "]";
	}

}
