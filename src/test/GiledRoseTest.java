package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.fiuba.tecnicas.giledrose.*;

public class GiledRoseTest {

	private Inventory inventory;
	private UpdatableItem[] items;
//	private Item[] items;

	public GiledRoseTest() {
		
	}
	
	@Before
	public void setUp() {

		items = new UpdatableItem[] {
            new GenericItem("+5 Dexterity Vest", 10, 20),
            new AgedBrie("Aged Brie", 2, 0),
            new GenericItem("Elixir of the Mongoose", 5, 7),
            new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),
            new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Conjured("Conjured Mana Cake", 3, 6)
		};
		inventory = new Inventory(items);
		
//		items = new Item[] {
//				new Item("+5 Dexterity Vest", 10, 20),
//				new Item("Aged Brie", 2, 0),
//				new Item("Elixir of the Mongoose", 5, 7),
//				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
//				new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
//				new Item("Conjured Mana Cake", 3, 6)
//		};
//		inventory = new Inventory(items);
	}
	
    @Test
    public void dexterityDecreasesQuality() {
        UpdatableItem item = items[0];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality - 1);
    }

    @Test
    public void agedBrieIncreaseQuality() {
    	UpdatableItem item = items[1];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality + 1);
    }

    @Test
    public void agedBrieQualityIsNotGreaterThan50() {
    	UpdatableItem item = items[1];
        for (int i = 0; i <= 60; i++) inventory.updateQuality();
        int finalQuality = item.getQuality();

        int maxQuality = 50;
        assertEquals(maxQuality, finalQuality);
    }

    @Test
    public void elixirDecreasesQuality() {
    	UpdatableItem item = items[2];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality - 1);
    }

    @Test
    public void sulfurasSteadyQuality() {
    	UpdatableItem item = items[3];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality);
    }

    @Test
    public void backstagePassesIncreasesQuality10Days() {
    	UpdatableItem item = items[4];
        inventory.updateQuality();
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality + 2);
    }
    
    @Test
    public void conjuredDecreasesQuality() {
    	UpdatableItem item = items[5];
    	int initialQuality = item.getQuality();
    	inventory.updateQuality();
    	
    	assertEquals(item.getQuality(), initialQuality - 2);
    }
}
