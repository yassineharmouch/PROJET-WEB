package com.server.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.server.dao.IGPSTracker;
import com.server.models.GPSTracker;

@Singleton(name = "GPSTRACKER")
public class GPSTrackerService implements IGPSTracker {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6230879021325483820L;
	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GPS-SER");

	public GPSTrackerService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(GPSTracker obj) {
	
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void modifier(GPSTracker obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		GPSTracker v = entityManager.find(GPSTracker.class, obj.getId());
		v.setPosition(obj.getPosition());
		v.setSimNumber(obj.getSimNumber());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void supprimer(GPSTracker obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (entityManager.contains(obj)) {
			entityManager.remove(obj);
		} else {
			entityManager.remove(entityManager.merge(obj));
		}

		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public GPSTracker findById(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		GPSTracker response = (GPSTracker) entityManager.find(GPSTracker.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return response;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GPSTracker> findAll() {
		// TODO Auto-generated method stub

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("from GPSTracker");
		@SuppressWarnings("unchecked")
		List<GPSTracker> liste = (List<GPSTracker>) query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return liste;
	}

}
