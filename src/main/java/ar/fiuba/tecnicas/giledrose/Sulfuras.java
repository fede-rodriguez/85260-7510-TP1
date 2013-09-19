package main.java.ar.fiuba.tecnicas.giledrose;

public class Sulfuras extends UpdatableItem {
	static int SULFURAS_MAX_QUALITY = 80;
	static int SULFURAS_MIN_QUALITY = 80;
	
	public Sulfuras(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		item.setQuality(SULFURAS_MAX_QUALITY);
	}

	@Override
	protected int getMaxQuality() {
		return SULFURAS_MAX_QUALITY;
	}

	@Override
	protected int getMinQuality() {
		return SULFURAS_MIN_QUALITY;
	}

	@Override
	public void updateSellIn() {
		item.setSellIn(item.getSellIn());
	}
}
