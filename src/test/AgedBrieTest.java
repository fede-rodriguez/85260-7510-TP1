package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.giledrose.AgedBrie;
import ar.fiuba.tecnicas.giledrose.UpdatableItem;

public class AgedBrieTest {

	@Test
	public void agedBrieIncreasesQuality() {
		UpdatableItem item = new AgedBrie("Aged Brie", 2, 0);
		int initialQuality = item.getQuality();
		item.updateQuality();
		
		assertEquals(item.getQuality(), initialQuality + 1);
	}
	
	@Test
	public void agedBrieIncreasesQualityUpTo50() {
		UpdatableItem item = new AgedBrie("Aged Brie", 2, 0);
		
		for (int i = 0; i <= 55; i++) 
			item.updateQuality();
		
		assertEquals(item.getQuality(), 50);
	}
}
