package ar.fiuba.tecnicas.giledrose;

public class GenericItem extends UpdatableItem {
	static int GENERIC_NORMAL_DELTA = -1;
	static int GENERIC_OVERDUE_DELTA = -2;
	static int GENERIC_MIN_QUALITY = 0;
	static int GENERIC_MAX_QUALITY = 50;
	
	public GenericItem(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		if (item.getSellIn() > 0)
			item.setQuality(item.getQuality() + GENERIC_NORMAL_DELTA);
		else
			item.setQuality(item.getQuality() + GENERIC_OVERDUE_DELTA);
		
		qualityBackIntoBounds();
	}

	@Override
	protected int getMaxQuality() {
		return GENERIC_MAX_QUALITY;
	}

	@Override
	protected int getMinQuality() {
		return GENERIC_MIN_QUALITY;
	}
}
