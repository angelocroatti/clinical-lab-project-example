package it.clinicallab.model.implementation;

import it.clinicallab.model.Box;
import it.clinicallab.model.BoxType;

public class StandardContainer extends AbstractContainer {

	public StandardContainer(int size) {
		super(size);
	}

	@Override
	public boolean canStoreBox(final Box box) {
		return box.type().equals(BoxType.STANDARD);
	}
}
