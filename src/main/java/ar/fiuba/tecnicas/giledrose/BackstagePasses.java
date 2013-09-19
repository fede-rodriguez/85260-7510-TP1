package main.java.ar.fiuba.tecnicas.giledrose;

public class BackstagePasses extends UpdatableItem {
	static int BACKSTAGE_MAX_QUALITY = 50;
	static int BACKSTAGE_MIN_QUALITY = 0;
	static int BACKSTAGE_NORMAL_DELTA = 1;
	static int BACKSTAGE_10_DAYS_BONUS = 1;
	static int BACKSTAGE_5_DAYS_BONUS = 1;
	
	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		if (isExpired())
			item.setQuality(0);
		else item.setQuality(item.getQuality() + fiveDaysQualityBonus()
											   + tenDaysQualityBonus()
											   + BACKSTAGE_NORMAL_DELTA);

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
	
	private int fiveDaysQualityBonus() {
		if (item.getSellIn() <= 5) 
			return BACKSTAGE_5_DAYS_BONUS;
		else return 0;
	}

	private int tenDaysQualityBonus() {
		if (item.getSellIn() <= 10) 
			return BACKSTAGE_10_DAYS_BONUS;
		else return 0;
	}
}
