package it.clinicallab.model;

import java.util.List;

public interface Train {
	
	String id();
	
	List<Container> containers();
	
	void performDelivery();
}
