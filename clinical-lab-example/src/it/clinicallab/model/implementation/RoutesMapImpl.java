package it.clinicallab.model.implementation;

import java.util.HashMap;
import java.util.Map;

import it.clinicallab.model.Route;
import it.clinicallab.model.RoutesMap;

public class RoutesMapImpl implements RoutesMap{
	
	private Map<String, Route> routes;
	
	public RoutesMapImpl() {
		routes = new HashMap<>();
	}
	
	@Override
	public void addRoute(final Route route) {
		routes.put(route.description(), route);
	}
	
	@Override
	public String[] routesArray(){
		return routes.keySet().stream().toArray(String[]::new);
	}

	@Override
	public Map<String, Route> routes() {
		return routes;
	}

}
