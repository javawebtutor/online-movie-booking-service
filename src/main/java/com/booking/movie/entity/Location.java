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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOCATION")
@Getter
@Setter
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOC_ID")
	@Setter(value = AccessLevel.NONE)
	private Long id;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Theatre> theatres = new ArrayList<>();
	
	public Location addTheatre(Theatre theatre){
        theatre.setLocation(this);
        theatres.add(theatre);
        return this;
    }

}
