package com.server.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 295379757362210520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String matricule;
	private String marque;
	private String type;
	private int km;

	// @OneToMany(mappedBy = "vehicule")
	// private Set<VehiculeGPSTracker> VehiculeGPSTracker;

	public Vehicule() {
		super();
	}

	public Vehicule(int id, String matricule, String marque, String type, int km) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		this.km = km;
	}

	public Vehicule(String matricule, String marque, String type, int km) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
