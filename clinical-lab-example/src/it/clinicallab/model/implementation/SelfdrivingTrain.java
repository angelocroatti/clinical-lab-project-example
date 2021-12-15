package it.clinicallab.model.implementation;

import java.util.ArrayList;
import java.util.List;

import it.clinicallab.model.Container;
import it.clinicallab.model.Train;

public class SelfdrivingTrain implements Train {

	private String id;
	private List<Container> containers;
	
	private SelfdrivingTrain() {
		containers = new ArrayList<Container>(); 
	}
	
	@Override
	public String id() {
		return id;
	}
	
	@Override
	public List<Container> containers() {
		return containers;
	}
	
	@Override
	public void performDelivery() {
		//Fake Implementation
		containers.forEach(c -> {
			c.removeAllBoxes();
		});
	}
	
	/**
	 * Selfdriving Train Builder
	 *
	 */
	public static class Builder {
		private String id;
		private List<Container> containers;
				
		public Builder(){
			containers = new ArrayList<Container>();
		}
		
		public Builder id(final String id) {
			this.id = id;
			return this;
		}
		
		public Builder addContainer(final Container container) {
			this.containers.add(container);
			return this;
		}
		
		public SelfdrivingTrain build() {
			SelfdrivingTrain train = new SelfdrivingTrain();
			train.id = this.id;
			
			this.containers.forEach(container -> {
				train.containers.add(container);
			});
			
			return train;
		}
	}
}
