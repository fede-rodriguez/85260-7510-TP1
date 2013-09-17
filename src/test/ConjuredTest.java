package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.giledrose.Conjured;
import ar.fiuba.tecnicas.giledrose.UpdatableItem;

public class ConjuredTest {

	@Test
	public void conjuredDecreasesTwiceFaster() {
		UpdatableItem item = new Conjured("Conjured Mana Cake", 3, 6);
		int initialQuality = item.getQuality();
		item.updateQuality();
		
		assertEquals(item.getQuality(), initialQuality - 2);
	}
	
	@Test
	public void conjuredDecreasesNoMoreThanZero() {
		UpdatableItem item = new Conjured("Conjured Mana Cake", 3, 6);
		
		for (int i = 0; i <= 10; i++) 
			item.updateQuality();
		
		assertEquals(item.getQuality(), 0);
	}
}
