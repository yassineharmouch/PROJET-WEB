package com.server.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Position implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1195497400877516094L;
	@Id
	private int id;
	private double longitude;
	private double laltitude;
	
	
	public Position() {
		super();
	}


	public Position(int id, double longitude, double laltitude) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.laltitude = laltitude;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLaltitude() {
		return laltitude;
	}


	public void setLaltitude(double laltitude) {
		this.laltitude = laltitude;
	}
	
	
	

}
