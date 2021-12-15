package it.clinicallab.application;

import it.clinicallab.controller.Hub;
import it.clinicallab.controller.HubFactory;
import it.clinicallab.view.Totem;

public class Main {

	public static void main(final String[] args) {
		
		
		final Hub hub = HubFactory.create();	
		
		new Totem(hub);
	}
}
