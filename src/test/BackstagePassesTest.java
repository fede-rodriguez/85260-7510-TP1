package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fiuba.tecnicas.giledrose.BackstagePasses;
import ar.fiuba.tecnicas.giledrose.UpdatableItem;

public class BackstagePassesTest {

	@Test
	public void backstagePassesIncreasesBy1() {
		UpdatableItem item = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		int initialQuality = item.getQuality();
		item.updateQuality();
		
		assertEquals(item.getQuality(), initialQuality + 1);
	}
	
	@Test
	public void backstagePassesIncreasesBy2() {
		UpdatableItem item = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		int initialQuality = item.getQuality();
		item.updateQuality();
		
		assertEquals(item.getQuality(), initialQuality + 2);
	}
	
	@Test
	public void backstagePassesIncreasesBy3() {
		UpdatableItem item = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		int initialQuality = item.getQuality();
		item.updateQuality();
		
		assertEquals(item.getQuality(), initialQuality + 3);
	}
	
	@Test
	public void backstagePassesFallTo0() {
		UpdatableItem item = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", -1, 20);
		item.updateQuality();
		
		assertEquals(item.getQuality(), 0);
	}
}
