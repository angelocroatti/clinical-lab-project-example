package it.clinicallab.controller;

import java.util.NoSuchElementException;

import it.clinicallab.model.Box;
import it.clinicallab.model.BoxType;
import it.clinicallab.model.Route;
import it.clinicallab.model.RoutesMap;
import it.clinicallab.model.implementation.BoxImpl;

public class Hub {
	
	private RoutesMap routesMap;
	
	public Hub(final RoutesMap routesMap) {
		this.routesMap = routesMap;
	}
	
	public RoutesMap getRoutesMap() {
		return routesMap;
	}
	
	public boolean addBoxDelivery(final String boxId, final boolean refrigerated, final String destinationPath) {		
		
		final Box box = new BoxImpl(boxId, refrigerated ? BoxType.REFRIGERATED : BoxType.STANDARD);
		
		final Response res = new Response();
			
		routesMap.routes().keySet().forEach(routeDescription -> {
			if(routeDescription.equals(destinationPath)) {
				try {
					final Route route = routesMap.routes().get(routeDescription);
					boolean r = route.train().containers().stream()
							.filter(c -> c.canStoreBox(box) && !c.isFull())
							.findFirst()
							.get()
							.storeBox(box);
					
					res.set(r);
				} catch(NoSuchElementException e) {
					res.set(false);
				}
			}
		});
	
		return res.get();
	}
	
	private class Response {
		private boolean response = false;
		
		public void set(final boolean response) {
			this.response = response;
		}
		
		public boolean get() {
			return response;
		}
	}
}
