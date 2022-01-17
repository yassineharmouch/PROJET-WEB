package com.server.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
public class VehiculeGPSTracker implements Serializable {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 482478549258542351L;

	@EmbeddedId
	VehiculeGPSTrackerKey id;

	@ManyToOne
	@MapsId("vehiculeId")
	@JoinColumn(name = "Vehicule_id")
	private Vehicule vehicule;

	@ManyToOne
	@MapsId("gpsTrackerId")
	@JoinColumn(name = "GPSTracker_id")
	private GPSTracker gpsTracker;

	private Date dateDebut;
	private Date dateFin;

	public VehiculeGPSTracker() {
		super();
	}

	public VehiculeGPSTracker(VehiculeGPSTrackerKey id, Vehicule vehicule, GPSTracker gpsTracker, Date dateDebut,
			Date dateFin) {
		super();
		this.id = id;
		this.vehicule = vehicule;
		this.gpsTracker = gpsTracker;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public VehiculeGPSTrackerKey getId() {
		return id;
	}

	public void setId(VehiculeGPSTrackerKey id) {
		this.id = id;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public GPSTracker getGpsTracker() {
		return gpsTracker;
	}

	public void setGpsTracker(GPSTracker gpsTracker) {
		this.gpsTracker = gpsTracker;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
