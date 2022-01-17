package com.server.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.server.dao.IPosition;
import com.server.models.Position;
import com.server.models.Position;

@Singleton(name = "POS")
public class PositionService  implements IPosition {

	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GPS-SER");
	/**
	 * 
	 */
	private static final long serialVersionUID = 8294263581668133611L;
	
	public PositionService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void ajouter(Position obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public void modifier(Position obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Position v = entityManager.find(Position.class, obj.getId());
		v.setLaltitude(obj.getLaltitude());
		v.setLongitude(obj.getLongitude());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void supprimer(Position obj) {
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
	public Position findById(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		Position response = (Position) entityManager.find(Position.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return response;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("from Position");
		@SuppressWarnings("unchecked")
		List<Position> liste = (List<Position>) query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return liste;
	}

}
