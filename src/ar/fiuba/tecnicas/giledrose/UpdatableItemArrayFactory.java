package ar.fiuba.tecnicas.giledrose;

public class UpdatableItemArrayFactory {

	public UpdatableItemArrayFactory() {
	}
	
	public static UpdatableItem[] build (Item[] items) {
		UpdatableItem[] newItemArray = new UpdatableItem[items.length];
		
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			switch (item.getName()) {
			case "Aged Brie":
				newItemArray[i] = new AgedBrie(item);
				break;
			case "Sulfuras, Hand of Ragnaros":
				newItemArray[i] = new Sulfuras(item);
				break;
			case "Backstage passes to a TAFKAL80ETC concert":
				newItemArray[i] = new BackstagePasses(item);
				break;
			case "Conjured Mana Cake":
				newItemArray[i] = new Conjured(item);
				break;
			default:
				newItemArray[i] = new GenericItem(item);
				break;
			}
		}
		return newItemArray;
	}
}
