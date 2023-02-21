package com.booking.movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SCREEN")
@Getter
@Setter
public class Screen {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long id;

    @Column(name = "SCREEN_NAME")
    private String screenName;

    @Column(name = "NO_OF_SEAT")
    private Integer noOfSeat;
    
    @ManyToOne
    @JoinColumn(name = "THEATRE_ID")
    private Theatre theatre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screen")
    private List<MovieShow> shows = new ArrayList<>();
    
    public Screen addMovieShow(MovieShow movieShow){
        movieShow.setScreen(this);
        shows.add(movieShow);
        return this;
    }
    
    public Screen() {
    }

    public Screen(String screenName, Integer noOfSeat, Theatre theatre) {
        this.screenName = screenName;
        this.noOfSeat = noOfSeat;
        this.theatre = theatre;
    }

	
	

}
