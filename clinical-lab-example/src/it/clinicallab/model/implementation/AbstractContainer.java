package it.clinicallab.model.implementation;

import java.util.ArrayList;
import java.util.List;

import it.clinicallab.applications.utils.ContainerObserver;
import it.clinicallab.model.Box;
import it.clinicallab.model.Container;

public abstract class AbstractContainer implements Container {

	private List<Box> boxes;
	private int size;
	
	private List<ContainerObserver> observers;
	
	public AbstractContainer(final int size) {
		this.size = size;
		boxes = new ArrayList<>();
		
		observers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(final ContainerObserver observer) {
		observers.add(observer);
	}

	@Override
	public boolean isFull() {
		return boxes.size() == size;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void removeAllBoxes() {
		boxes = new ArrayList<>();
		notifyObservers();
	}

	@Override
	public boolean storeBox(final Box box) {
		if(!isFull() && canStoreBox(box)) {
			boxes.add(box);
			
			notifyObservers();
			
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public abstract boolean canStoreBox(final Box box);

	@Override
	public List<Box> storedBoxes() {
		return boxes;
	}
	
	private void notifyObservers() {
		observers.forEach(obs -> {
			obs.onContainerUpdated();
		});
	}
}
