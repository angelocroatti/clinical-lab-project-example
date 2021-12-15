package it.clinicallab.model;

public enum BoxType {
	STANDARD("standard"),
	REFRIGERATED("refrigerated");
	
	private String description;
	
	BoxType(final String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
