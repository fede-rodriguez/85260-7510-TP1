package ar.fiuba.tecnicas.giledrose;

public class Sulfuras extends UpdatableItem {
	static int MAX_QUALITY = 80;
	static int MAX_SELL_IN  = 0;
	
	public Sulfuras(String name, int sellIn, int quality) {
		super(name, MAX_SELL_IN, MAX_QUALITY);
	}

	@Override
	public void updateQuality() {
		setQuality(MAX_QUALITY);
	}
	
	@Override
	public void setSellIn(int sellIn) {
		super.setSellIn(MAX_SELL_IN);
	}
	
	@Override
	public void setQuality(int quality) {
		super.setQuality(MAX_QUALITY);
	}
}
