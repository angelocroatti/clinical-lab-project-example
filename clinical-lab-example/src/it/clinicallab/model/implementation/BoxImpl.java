package it.clinicallab.model.implementation;

import it.clinicallab.model.Box;
import it.clinicallab.model.BoxType;

public class BoxImpl implements Box{

	private String id;
	private BoxType type;
	
	public BoxImpl(final String id, final BoxType type) {
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String id() {
		return id;
	}
	
	@Override
	public BoxType type() {
		return type;
	}

	
	@Override
	public String toString() {
		return "[" + id + " : " + type.toString() + "]";
	}
}
