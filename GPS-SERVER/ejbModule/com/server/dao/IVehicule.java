package com.server.dao;

import java.util.List;

import javax.ejb.Local;
import com.server.models.Vehicule;


@Local
public interface IVehicule  {
	public void ajouter(Vehicule obj);
	public void modifier(Vehicule obj);
	public void supprimer(Vehicule obj);
	public Vehicule findById(int id);
	public List<Vehicule> findAll();
}
