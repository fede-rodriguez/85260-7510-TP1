package ar.fiuba.tecnicas.giledrose;

public class BackstagePasses extends UpdatableItem {
	static int BACKSTAGE_MAX_QUALITY = 50;
	static int BACKSTAGE_MIN_QUALITY = 0;
	static int BACKSTAGE_NORMAL_DELTA = 1;
	static int BACKSTAGE_10_DAYS_DELTA = 2;
	static int BACKSTAGE_5_DAYS_DELTA = 3;
	
	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		if (item.getSellIn() <= 0)
			item.setQuality(0);
		else if (item.getSellIn() <= 5)
			item.setQuality(item.getQuality() + BACKSTAGE_5_DAYS_DELTA);
		else if (item.getSellIn() <= 10)
			item.setQuality(item.getQuality() + BACKSTAGE_10_DAYS_DELTA);
		else item.setQuality(item.getQuality() + BACKSTAGE_NORMAL_DELTA);

		qualityBackIntoBounds();
	}

	@Override
	protected int getMaxQuality() {
		return BACKSTAGE_MAX_QUALITY;
	}

	@Override
	protected int getMinQuality() {
		return BACKSTAGE_MIN_QUALITY;
	}
}
