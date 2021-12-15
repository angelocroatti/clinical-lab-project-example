package it.clinicallab.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import it.clinicallab.controller.Hub;

public class Totem {
	
	public Totem(final Hub hub) {
		createViews(
			new TotemDashboard(hub),
			new TotemInputPad(hub)
		);
	}
	
	private void createViews(final JFrame... views) {		
		for (final JFrame view : views) {
			view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			view.setVisible(true);
		}
	}
}
