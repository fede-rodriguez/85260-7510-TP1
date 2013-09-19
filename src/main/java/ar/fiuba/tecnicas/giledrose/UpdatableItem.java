package main.java.ar.fiuba.tecnicas.giledrose;

public abstract class UpdatableItem {
	protected Item item;

	public UpdatableItem(Item item) {
		this.item = item;
	}
	
	public abstract void updateQuality();

	protected void qualityBackIntoBounds() {
		if (item.getQuality() < getMinQuality())
			item.setQuality(getMinQuality());

		if (item.getQuality() > getMaxQuality())
			item.setQuality(getMaxQuality());
	}
	
	public void updateSellIn() {
		item.setSellIn(item.getSellIn() - 1);
	}
	
	protected boolean isExpired() {
		return (item.getSellIn() <= 0);
	}
	
	abstract protected int getMaxQuality();

	abstract protected int getMinQuality();
	
}
