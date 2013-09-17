package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.giledrose.Sulfuras;
import ar.fiuba.tecnicas.giledrose.UpdatableItem;

public class SulfurasTest {

	@Test
	public void sulfurasDontChangeQuality() {
		UpdatableItem item = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
		
		for (int i = 0; i <= 10; i++)
			item.updateQuality();
		
		assertEquals(item.getQuality(), 80);
	}

}
