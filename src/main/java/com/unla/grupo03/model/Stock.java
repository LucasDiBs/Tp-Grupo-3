package com.unla.grupo03.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter 
@Setter
@ToString
@NoArgsConstructor

public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="stock", cascade = {CascadeType.ALL})
	private Set<Lot> lotes = new HashSet<>();;

	
	
	public Stock(Set<Lot> lotes) {

		this.lotes = lotes;
	}


	
}
