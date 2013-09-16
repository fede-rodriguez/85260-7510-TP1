package ar.fiuba.tecnicas.giledrose;

public class AgedBrie extends UpdatableItem {
	static int MAX_QUALITY = 50;

	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		if (getQuality() < MAX_QUALITY)
			setQuality(getQuality() + 1);
	}

}
