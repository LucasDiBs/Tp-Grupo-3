package com.unla.grupo03.model;

import java.util.List;

public class Stock {

	private List<Lot> lotes;

	public Stock() {}

	public Stock(List<Lot> lotes) {

		this.lotes = lotes;
	}

	public List<Lot> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lot> lotes) {
		this.lotes = lotes;
	}
	
	
	
	
}
