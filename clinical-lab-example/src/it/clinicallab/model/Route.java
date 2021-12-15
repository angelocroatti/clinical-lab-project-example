package it.clinicallab.model;

import java.util.List;

import it.clinicallab.applications.utils.RouteObserver;

public interface Route {
	List<Building> buildings();
	
	Train train();
	void train(Train train);

	void addObserver(RouteObserver observer);

	String description();
}
