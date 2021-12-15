package it.clinicallab.view;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.*;

import it.clinicallab.applications.utils.RouteObserver;
import it.clinicallab.controller.Hub;
import it.clinicallab.model.Train;

@SuppressWarnings("serial")
public class TotemDashboard extends JFrame implements RouteObserver{
	
	private final Hub hub;
	
	private Map<String, JTextArea> infoAreas;
	
	public TotemDashboard(final Hub hub) {
		this.hub = hub;
		this.infoAreas = new HashMap<String, JTextArea>();
		
		setTitle("ClinicalLab - Dashboard");
		
		initUI();
		
		pack();
				
		hub.getRoutesMap().routes().forEach((k,v)-> {
			v.addObserver(this);
		});
	}
	
	private void initUI() {
		setResizable(false);
		
		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		for(final String route : hub.getRoutesMap().routesArray()) {
			final JPanel routePanel = new JPanel();
			routePanel.setBorder(BorderFactory.createTitledBorder(route));
			
			final JTextArea routeArea = new JTextArea();
			routeArea.setPreferredSize(new Dimension(400, 100));
			infoAreas.put(route, routeArea);
			routePanel.add(routeArea);
			
			
			final JButton btn = new JButton("Start Delivery!");
			btn.addActionListener( event -> {
				hub.getRoutesMap().routes().get(route).train().performDelivery();
			});
			
			routePanel.add(btn);
			
			mainPanel.add(routePanel);
		}
			
		getContentPane().add(mainPanel);
	}

	
	@Override
	public void onRouteTrainUpdated(final String routeDescription, final Train t) {
		
		final StringBuilder sb = new StringBuilder();
		
		sb.append("Train ID = " + t.id());
		
		t.containers().forEach(c -> {
			if(c.storedBoxes().size() != 0) {
				sb.append("\n > " + c.getClass().getSimpleName() + ":" + c.storedBoxes().size() + "\n");
				c.storedBoxes().forEach(b -> {
					sb.append(b.toString());
				});
			}
		});
		
		
		
		infoAreas.get(routeDescription).setText(sb.toString());
		
	}

}
