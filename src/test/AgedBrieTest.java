package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ar.fiuba.tecnicas.giledrose.*;

class AgedBrieTest {

	@Before
	public void setUp() {

		Item[] listaItem = null;
		Item item = new Item("Aged Brie", 2, 0);
		listaItem[0] = item;
		Inventory inventory = new Inventory(listaItem);
		
		inventory.updateQuality();
		this.testSellIn(listaItem[0]);
	}
	
	@Test
	public void testSellIn(Item item) {
		assertEquals(0, item.getSellIn());
	}

	@Test
	public void testQuality(Item item) {
		assertEquals(1, item.getQuality());
	}
}
