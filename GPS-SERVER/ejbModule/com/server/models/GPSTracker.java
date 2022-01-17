package com.server.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GPSTracker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1492165604946045395L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String simNumber	;
	
	@ManyToOne @JoinColumn(name="idPosition")
	private Position position;
	
	public GPSTracker() {
		super();
	}


	public GPSTracker(int id, String simNumber) {
		super();
		this.id = id;
		this.simNumber = simNumber;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSimNumber() {
		return simNumber;
	}


	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	
	
	
}
