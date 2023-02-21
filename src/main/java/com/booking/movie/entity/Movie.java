package com.booking.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MOVIE")
@Getter
@Setter
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private Long id;

	@Column(name = "MOVIE_NAME")
	private String name;

	@Column(name = "MOVIE_LANGUAGE")
	private String language;

	@Column(name = "GENRE")
	private String genre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieShow> shows = new ArrayList<>();
	
	//making bidirectional
    public Movie addShow(MovieShow movieShow){
        movieShow.setMovie(this);
        shows.add(movieShow);
        return this;
    }

}
