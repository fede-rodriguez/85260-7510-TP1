package ar.fiuba.tecnicas.giledrose;

public class GenericItem extends UpdatableItem {

	public GenericItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		if (getQuality() >= 1)
			if (getSellIn() > 0)
				setQuality(getQuality() - 1);
			else
				setQuality(getQuality() - 2);
	}
}
