package it.clinicallab.model;

import java.util.Map;

public interface RoutesMap {

	Map<String, Route> routes();

	void addRoute(Route route);

	String[] routesArray();
}
