package ar.fiuba.tecnicas.giledrose;

public class Conjured extends UpdatableItem {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		if (getQuality() >= 2)
			setQuality(getQuality() - 2);
		else if (getQuality() == 1)
			setQuality(getQuality() - 1);
	}

}
