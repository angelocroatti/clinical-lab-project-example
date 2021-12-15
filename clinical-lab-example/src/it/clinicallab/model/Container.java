package it.clinicallab.model;

import java.util.List;

import it.clinicallab.applications.utils.ContainerObserver;

public interface Container {

	boolean isFull();
	int size();
	
	void removeAllBoxes();
	
	List<Box> storedBoxes();
	
	boolean storeBox(final Box box);
	boolean canStoreBox(final Box box);
	
	void registerObserver(ContainerObserver observer);
}
