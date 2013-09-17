package ar.fiuba.tecnicas.giledrose;

public class BackstagePasses extends UpdatableItem {

	public BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		int sellIn = getSellIn();
		if (sellIn <= 0)
			setQuality(0);
		else if (sellIn <= 5)
			setQuality(getQuality() + 3);
		else if (sellIn <= 10)
			setQuality(getQuality() + 2);
		else setQuality(getQuality() + 1);
	}
}
