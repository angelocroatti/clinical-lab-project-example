package it.clinicallab.model.implementation;

import java.util.ArrayList;
import java.util.List;

import it.clinicallab.applications.utils.ContainerObserver;
import it.clinicallab.applications.utils.RouteObserver;
import it.clinicallab.model.Building;
import it.clinicallab.model.Route;
import it.clinicallab.model.Train;

public class RouteImpl implements Route, ContainerObserver{
	
	private String description;
	private List<Building> buildings;
	private Train train;
	
	private List<RouteObserver> observers;
	
	public RouteImpl(final String description) {
		buildings = new ArrayList<>();
		observers = new ArrayList<>();
		
		this.description = description;
	}
	
	@Override
	public String description() {
		return this.description;
	}

	@Override
	public List<Building> buildings() {
		return buildings;
	}

	@Override
	public Train train() {
		return train;
	}
	
	@Override
	public void train(final Train train) {
		this.train = train;
		
		this.train.containers().forEach(c -> c.registerObserver(this));
	}
	
	@Override
	public void addObserver(final RouteObserver observer) {
		observers.add(observer);
	}

	@Override
	public void onContainerUpdated() {
		observers.forEach(obs -> {
			obs.onRouteTrainUpdated(description, train);
		});
	}
}
