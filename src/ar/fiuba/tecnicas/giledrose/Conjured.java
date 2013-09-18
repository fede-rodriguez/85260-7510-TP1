package ar.fiuba.tecnicas.giledrose;

public class Conjured extends UpdatableItem {
	static int CONJURED_NORMAL_DELTA = -2;
	static int CONJURED_OVERDUE_DELTA = -4;
	static int CONJURED_MIN_QUALITY = 0;
	static int CONJURED_MAX_QUALITY = 50;

	public Conjured(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		if (item.getSellIn() > 0)
			item.setQuality(item.getQuality() + CONJURED_NORMAL_DELTA);
		else
			item.setQuality(item.getQuality() + CONJURED_OVERDUE_DELTA);

		qualityBackIntoBounds();
	}

	@Override
	protected int getMaxQuality() {
		return CONJURED_MAX_QUALITY;
	}

	@Override
	protected int getMinQuality() {
		return CONJURED_MIN_QUALITY;
	}
}
