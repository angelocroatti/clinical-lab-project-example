package it.clinicallab.applications.utils;

import it.clinicallab.model.Train;

public interface RouteObserver {
	void onRouteTrainUpdated(final String routeDescription, final Train t);
}
