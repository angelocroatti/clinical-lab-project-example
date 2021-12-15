package it.clinicallab.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.clinicallab.model.*;
import it.clinicallab.model.implementation.*;

class TrainTest {

	@Test
	void trainCreationTest() {
		final Train t = new SelfdrivingTrain.Builder()
				.id("train-01")
				.addContainer(new RefrigeratedContainer(5))
				.addContainer(new StandardContainer(10))
				.build();
		
		assertEquals("train-01", t.id());
		assertEquals(2, t.containers().size());
	}
	
	@Test
	void containerStorageTest() {
		final Train t = new SelfdrivingTrain.Builder()
				.id("train-01")
				.addContainer(new RefrigeratedContainer(5))
				.addContainer(new StandardContainer(10))
				.build();
		
		final Container c = t.containers().get(0);
		
		c.storeBox(new BoxImpl("box01", BoxType.REFRIGERATED));
		assertEquals(1, c.storedBoxes().size());
		
		c.storeBox(new BoxImpl("box02", BoxType.STANDARD));
		assertEquals(1, c.storedBoxes().size());
		
		c.storeBox(new BoxImpl("box03", BoxType.REFRIGERATED));
		assertEquals(2, c.storedBoxes().size());
	}
}
