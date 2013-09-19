package main.java.ar.fiuba.tecnicas.giledrose;

public class UpdatableItemArrayFactory {

	public UpdatableItemArrayFactory() {
	}

	public static UpdatableItem[] buildArray (Item[] items) {
		UpdatableItem[] newItemArray = new UpdatableItem[items.length];

		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			if (item.getName() ==  "Aged Brie")
				newItemArray[i] = new AgedBrie(item);
			else if (item.getName() == "Sulfuras, Hand of Ragnaros")
				newItemArray[i] = new Sulfuras(item);
			else if (item.getName() == "Backstage passes to a TAFKAL80ETC concert")
				newItemArray[i] = new BackstagePasses(item);
			else if (item.getName() == "Conjured Mana Cake")
				newItemArray[i] = new Conjured(item);
			else
				newItemArray[i] = new GenericItem(item);
		}
		return newItemArray;
	}
}
