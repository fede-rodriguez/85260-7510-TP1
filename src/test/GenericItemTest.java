package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.giledrose.GenericItem;
import ar.fiuba.tecnicas.giledrose.UpdatableItem;

public class GenericItemTest {

	@Test
	public void genericItemDecreasesQualityBy1() {
		UpdatableItem item = new GenericItem("Cheese", 5, 20);
		int initialQuality = item.getQuality();
		
		item.updateQuality();
		assertEquals(item.getQuality(), initialQuality - 1);
	}
	
	@Test
	public void genericItemDecreasesQualityTwiceFaster() {
		UpdatableItem item = new GenericItem("Cheese", 0, 20);
		int initialQuality = item.getQuality();
		
		item.updateQuality();
		assertEquals(item.getQuality(), initialQuality - 2);
	}
}
