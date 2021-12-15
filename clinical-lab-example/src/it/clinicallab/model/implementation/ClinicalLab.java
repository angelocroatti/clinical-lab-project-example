package it.clinicallab.model.implementation;

import it.clinicallab.model.Building;

public class ClinicalLab implements Building{
	private String description;
	private boolean refrigeratedBoxesAccepted;
	
	public ClinicalLab(final String description, boolean refrigeratedBoxesAccepted) {
		this.description = description;
		this.refrigeratedBoxesAccepted = refrigeratedBoxesAccepted;
	}

	@Override
	public String description() {
		return description;
	}

	@Override
	public boolean refrigeratedBoxesAccepted() {
		return refrigeratedBoxesAccepted;
	}
}
