package com.server.dao;

import java.util.List;

import javax.ejb.Local;

import com.server.models.GPSTracker;

@Local
public interface IVehiculeGPSTracker {
	public void ajouter(IVehiculeGPSTracker obj);
	public void modifier(IVehiculeGPSTracker obj);
	public void supprimer(IVehiculeGPSTracker obj);
	public GPSTracker findById(int id);
	public List<GPSTracker> findAll();
}
