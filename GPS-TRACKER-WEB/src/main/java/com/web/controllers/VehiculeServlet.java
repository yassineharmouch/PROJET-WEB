package com.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.server.dao.IVehicule;
import com.server.models.Vehicule;

/**
 * Servlet implementation class VehiculeServlet
 */
@WebServlet(name = "VehiculeServlet", urlPatterns = { "/VehiculeServlet" })
public class VehiculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	public IVehicule iVehicule;

	public VehiculeServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Vehicule> vehiculeList = iVehicule.findAll();
		response.setContentType("application/json");
		request.setAttribute("vehicules", vehiculeList);
		Gson gsonObj = new Gson();
		request.setAttribute("vehiculesPoints", gsonObj.toJson(getVehiculesListByKm(vehiculeList)));

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		if (request.getParameter("action") != null) {

			String action = request.getParameter("action");
			String matricule = request.getParameter("matricule");
			String marque = request.getParameter("marque");
			String type = request.getParameter("type");
			String km = request.getParameter("km");
			List<Vehicule> vehiculeList = iVehicule.findAll();
			switch (action) {
			case "doAdd":
				iVehicule.ajouter(new Vehicule(matricule, marque, type, Integer.parseInt(km)));
				break;
			case "doUpdate":
				String id = request.getParameter("idVehicule");
				iVehicule.modifier(new Vehicule(Integer.parseInt(id), matricule, marque, type, Integer.parseInt(km)));
				break;
			case "doDelete":
				String idSupp = request.getParameter("idVehiculeSupp");
				iVehicule.supprimer(iVehicule.findById(Integer.parseInt(idSupp)));
				break;
			case "doDeleteAll":
				for (int i = 0; i < vehiculeList.size(); i++) {
					iVehicule.supprimer(iVehicule.findById(vehiculeList.get(i).getId()));
				}
				break;
			default:
				break;
			}
			response.setContentType("application/json");
			
			request.setAttribute("vehicules", vehiculeList);
			Gson gsonObj = new Gson();
			request.setAttribute("dataPoints", gsonObj.toJson(getVehiculesListByKm(vehiculeList)));
			response.sendRedirect(request.getContextPath() + "/gestionVehicule");


		}
		doGet(request, response);
	}

	public List<Map<Object, Object>> getVehiculesListByKm(List<Vehicule> vehiculeList) {

		Gson gsonObj = new Gson();
		Map<Object, Object> map = null;
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

		for (int i = 0; i < vehiculeList.size(); i++) {
		
			map = new HashMap<Object, Object>();
			map.put("label", vehiculeList.get(i).getMatricule());
			map.put("y", vehiculeList.get(i).getKm());
			list.add(map);
		
		}

	

		return list;
	}

}
