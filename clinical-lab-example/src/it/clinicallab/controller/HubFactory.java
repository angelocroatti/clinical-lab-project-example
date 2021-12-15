package it.clinicallab.controller;

import it.clinicallab.model.Route;
import it.clinicallab.model.RoutesMap;
import it.clinicallab.model.implementation.ClinicalLab;
import it.clinicallab.model.implementation.RefrigeratedContainer;
import it.clinicallab.model.implementation.RouteImpl;
import it.clinicallab.model.implementation.RoutesMapImpl;
import it.clinicallab.model.implementation.SelfdrivingTrain;
import it.clinicallab.model.implementation.StandardContainer;

public class HubFactory {
	
	private HubFactory() { }
	
	public static Hub create() {
		final RoutesMap routesMap = defineHubMap();
		return new Hub(routesMap);
	}
	
	private static RoutesMap defineHubMap() {
		final Route bloodPath = new RouteImpl("Blood Route");
		bloodPath.buildings().add(new ClinicalLab("Blood Lab 01", false));
		bloodPath.buildings().add(new ClinicalLab("Blood Lab 02", true));
		bloodPath.buildings().add(new ClinicalLab("Blood Lab 03", true));
		
		final SelfdrivingTrain bloodPathTrain = new SelfdrivingTrain.Builder()
				.id("Train #1")
				.addContainer(new StandardContainer(5))
				.addContainer(new StandardContainer(5))
				.addContainer(new RefrigeratedContainer(5))
				.addContainer(new RefrigeratedContainer(5))
				.build();
		
		bloodPath.train(bloodPathTrain);
		
		final Route histologicalPath = new RouteImpl("Histological Route");
		histologicalPath.buildings().add(new ClinicalLab("Histological Lab", true));
		
		final SelfdrivingTrain histologicalPathTrain = new SelfdrivingTrain.Builder()
				.id("Train #2")
				.addContainer(new StandardContainer(5))
				.addContainer(new RefrigeratedContainer(5))
				.build();
		
		histologicalPath.train(histologicalPathTrain);
		
		final Route genericPath = new RouteImpl("Generic Route");
		genericPath.buildings().add(new ClinicalLab("Generic Clinical Lab 01", false));
		genericPath.buildings().add(new ClinicalLab("Generic Clinical Lab 02", false));
		
		final SelfdrivingTrain genericPathTrain = new SelfdrivingTrain.Builder()
				.id("Train #3")
				.addContainer(new StandardContainer(5))
				.addContainer(new StandardContainer(5))
				.addContainer(new StandardContainer(5))
				.build();
		
		genericPath.train(genericPathTrain);
		
		RoutesMap routes = new RoutesMapImpl();
		routes.addRoute(bloodPath);
		routes.addRoute(histologicalPath);
		routes.addRoute(genericPath);
		
		return routes;
	}
}
