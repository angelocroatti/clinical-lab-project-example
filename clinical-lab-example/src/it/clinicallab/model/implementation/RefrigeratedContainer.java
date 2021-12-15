package it.clinicallab.model.implementation;

import it.clinicallab.model.Box;
import it.clinicallab.model.BoxType;

public class RefrigeratedContainer extends AbstractContainer {

	public RefrigeratedContainer(int size) {
		super(size);
	}

	@Override
	public boolean canStoreBox(final Box box) {
		return box.type().equals(BoxType.REFRIGERATED);
	}
}
