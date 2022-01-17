package com.server.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.server.dao.IVehiculeGPSTracker;
import com.server.models.GPSTracker;
import com.server.models.VehiculeGPSTracker;

public class VehiculeGPSTrackerGPSTrackerService implements IVehiculeGPSTracker  {

	private static final long serialVersionUID = -514038942805414292L;

	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GPS-SER");

	public VehiculeGPSTrackerGPSTrackerService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(IVehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void modifier(IVehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(IVehiculeGPSTracker obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GPSTracker findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GPSTracker> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
