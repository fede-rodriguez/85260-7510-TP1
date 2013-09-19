package main.java.ar.fiuba.tecnicas.giledrose;

public class AgedBrie extends UpdatableItem {
	static int AGED_BRIE_MAX_QUALITY = 50;
	static int AGED_BRIE_MIN_QUALITY = 0;
	static int AGED_BRIE_REGULAR_DELTA = 1;

	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		item.setQuality(item.getQuality() + AGED_BRIE_REGULAR_DELTA);
		qualityBackIntoBounds();
	}

	@Override
	protected int getMaxQuality() {
		return AGED_BRIE_MAX_QUALITY;
	}

	@Override
	protected int getMinQuality() {
		return AGED_BRIE_MIN_QUALITY;
	}
}
