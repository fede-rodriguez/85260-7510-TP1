package ar.fiuba.tecnicas.giledrose;

public class QualityUpdater {
	static int AGED_BRIE_MAX_QUALITY = 50;
	static int SULFURAS_MAX_QUALITY = 80;
	static int CONJURED_MAX_QUALITY = 50;
	static int BACKSTAGE_MAX_QUALITY = 50;
	static int GENERIC_MAX_QUALITY = 50;
	static int CONJURED_NORMAL_DELTA = -2;
	static int GENERIC_NORMAL_DELTA = -1;
	static int GENERIC_OVERDUE_DELTA = -2;
	static int BACKSTAGE_NORMAL_DELTA = 1;
	static int BACKSTAGE_10_DAYS_DELTA = 2;
	static int BACKSTAGE_5_DAYS_DELTA = 3;

	public QualityUpdater() {
	}

	public static void updateQuality(Item item) {
		switch (item.getName()) {
		case "Aged Brie":
			updateQualityAgedBrie(item);
			break;
		case "Sulfuras, Hand of Ragnaros":
			updateQualitySulfuras(item);
			break;
		case "Backstage passes to a TAFKAL80ETC concert":
			updateQualityBackstagePasses(item);
			break;
		case "Conjured Mana Cake":
			updateQualityConjured(item);
			break;
		default:
			updateQualityGenericItem(item);
			break;
		}
	}

	private static void updateQualityAgedBrie(Item item) {
		if (item.getQuality() < AGED_BRIE_MAX_QUALITY)
			item.setQuality(item.getQuality() + 1);
	}

	private static void updateQualitySulfuras(Item item) {
		item.setQuality(SULFURAS_MAX_QUALITY);
	}

	private static void updateQualityBackstagePasses(Item item) {
		int sellIn = item.getSellIn();
		if (sellIn <= 0)
			item.setQuality(0);
		else if (sellIn <= 5)
			item.setQuality(item.getQuality() + BACKSTAGE_5_DAYS_DELTA);
		else if (sellIn <= 10)
			item.setQuality(item.getQuality() + BACKSTAGE_10_DAYS_DELTA);
		else item.setQuality(item.getQuality() + BACKSTAGE_NORMAL_DELTA);
	}

	private static void updateQualityConjured(Item item) {
		if (item.getQuality() >= CONJURED_NORMAL_DELTA)
			item.setQuality(item.getQuality() + CONJURED_NORMAL_DELTA);
		else if (item.getQuality() < CONJURED_NORMAL_DELTA && item.getQuality() > 0)
			item.setQuality(item.getQuality() - 1);
	}

	private static void updateQualityGenericItem(Item item) {
		if (item.getQuality() >= GENERIC_NORMAL_DELTA)
			if (item.getSellIn() > 0)
				item.setQuality(item.getQuality() + GENERIC_NORMAL_DELTA);
			else 
				item.setQuality(item.getQuality() + GENERIC_OVERDUE_DELTA);

	}
}
