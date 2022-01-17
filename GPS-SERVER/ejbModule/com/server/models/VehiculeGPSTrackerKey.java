package com.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VehiculeGPSTrackerKey implements Serializable {
	
	/**
	 * 
	 * 
	 */
	
	private static final long serialVersionUID = -4743625472005847772L;

	@Column(name = "Vehicule_id")
	int vehiculeId;

	@Column(name = "GPSTracker_id")
	int gpsTrackerId;
	
	
	
	// standard constructors, getters, and setters
    // hashcode and equals implementation
	
	
}
