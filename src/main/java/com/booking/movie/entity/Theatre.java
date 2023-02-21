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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="THEATRE")
@Getter
@Setter
public class Theatre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATRE_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name = "THEATRE_NAME")
    private String theatreName;

    @Column(name = "NO_OF_SCREEN")
    private Integer noOfScreen;

    @ManyToOne
    @JoinColumn(name="LOC_ID")
    private Location location;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private List<Screen> screens = new ArrayList<>();

    public Theatre(){}

    public Theatre(String theatreName, Integer noOfScreen, Location location) {
        this.theatreName = theatreName;
        this.noOfScreen = noOfScreen;
        this.location = location;
    }

    //Bidirectional
    public Theatre addScreen(Screen screen){
        screen.setTheatre(this);
        screens.add(screen);
        return this;
    }

}
