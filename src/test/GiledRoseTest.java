package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ar.fiuba.tecnicas.giledrose.*;

public class GiledRoseTest {

	private Inventory inventario;
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
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
            new Item("Conjured Mana Cake", 3, 6)
        };
        inventario = new Inventory(items);
	}
	
    @Test
    public void dexterityDecrementaCalidad() {
        Item item = items[0];
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal + 1, qualityInicial);
    }

    @Test
    public void agedBrieIncrementaCalidad() {
        Item item = items[1];
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal -1, qualityInicial);
    }

    @Test
    public void agedBrieNoSuperaCalidad50() {
        Item item = items[1];

        for (int i = 27; i > 0; i--) inventario.updateQuality();
        int qualityFinal = item.getQuality();

        int CalidadMaxima = 50;
        assertEquals(CalidadMaxima, qualityFinal);
    }

    @Test
    public void elixirDecrementaCalidad() {
        Item item = items[2];
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal + 1, qualityInicial);
    }

    @Test
    public void sulfurasCalidadInvariante() {
        Item item = items[3];
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal, qualityInicial);
    }

    @Test
    public void backstageIncrementaCalidad() {
        Item item = items[4];
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal - 1, qualityInicial);
    }

    @Test
    public void backstageIncrementaCalidad10Dias()
    {
        Item item = items[4];
        inventario.updateQuality();
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal - 2, qualityInicial);
    }

    @Test
    public void backstageIncrementaCalidad5Dias() {
        Item item = items[4];
        for (int i = 15; i > 0; i--) inventario.updateQuality();
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = 0;

        assertEquals(qualityFinal, qualityInicial);
    }

    @Test
    public void backstageIncrementaCalidad0Dias() {
        Item item = items[4];
        inventario.updateQuality();
        inventario.updateQuality();
        inventario.updateQuality();
        inventario.updateQuality();
        inventario.updateQuality();
        inventario.updateQuality();
        int qualityInicial = item.getQuality();
        inventario.updateQuality();
        int qualityFinal = item.getQuality();

        assertEquals(qualityFinal - 3, qualityInicial);
    }
    
    @Test
    public void conjuredDecrementaCalidad() {
    	Item item = items[5];
    	int qualityInicial = item.getQuality();
    	inventario.updateQuality();
    	
    	assertEquals(item.getQuality(), qualityInicial - 2);
    }
}
