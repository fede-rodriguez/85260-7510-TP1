package test.java.ar.fiuba.tecnicas.giledrose;

import static org.junit.Assert.*;
import main.java.ar.fiuba.tecnicas.giledrose.*;

import org.junit.Before;
import org.junit.Test;

public class GiledRoseTest {

	private Inventory inventory;
	private Item[] items;

	public GiledRoseTest() {
	
	}
	
	@Before
	public void setUp() {
		
		items = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20),
				new Item("Conjured Mana Cake", 3, 9)
		};
		inventory = new Inventory(items);
	}
	
    @Test
    public void dexterityDecreasesQuality() {
        Item item = items[0];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality - 1);
    }

    @Test
    public void agedBrieIncreaseQuality() {
    	Item item = items[1];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality + 1);
    }

    @Test
    public void agedBrieQualityIsNotGreaterThan50() {
    	Item item = items[1];
        for (int i = 0; i <= 60; i++) inventory.updateQuality();
        int finalQuality = item.getQuality();

        int maxQuality = 50;
        assertEquals(maxQuality, finalQuality);
    }

    @Test
    public void elixirDecreasesQuality() {
    	Item item = items[2];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality - 1);
    }

    @Test
    public void sulfurasSteadyQuality() {
    	Item item = items[3];
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality);
    }

    @Test
    public void backstagePassesIncreasesQuality10Days() {
    	Item item = items[4];
        inventory.updateQuality();
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality + 2);
    }
    
    @Test
    public void backstagePassesIncreasesQuality5Days() {
    	Item item = items[4];
        inventory.updateQuality();
        inventory.updateQuality();
        inventory.updateQuality();
        inventory.updateQuality();
        inventory.updateQuality();
        inventory.updateQuality();
        int initialQuality = item.getQuality();
        inventory.updateQuality();
        int finalQuality = item.getQuality();

        assertEquals(finalQuality, initialQuality + 3);
    }
    
    @Test
    public void conjuredDecreasesQuality() {
    	Item item = items[5];
    	int initialQuality = item.getQuality();
    	inventory.updateQuality();
    	
    	assertEquals(item.getQuality(), initialQuality - 2);
    }
    
    @Test
    public void conjuredDecreasesQualityAfterExpired() {
    	Item item = items[5];
    	inventory.updateQuality();
    	inventory.updateQuality();
    	int initialQuality = item.getQuality();
    	inventory.updateQuality();
    	
    	assertEquals(item.getQuality(), initialQuality - 4);
    }
}
