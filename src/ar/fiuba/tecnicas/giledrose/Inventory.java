package ar.fiuba.tecnicas.giledrose;

public class Inventory {
	private UpdatableItem[] items;

    public Inventory(Item[] items) {
        super();
        this.items = UpdatableItemArrayFactory.build(items);
    }

    public Inventory() {
        super();
        Item[] plainItems = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };
        this.items = UpdatableItemArrayFactory.build(plainItems);
    }

    public void updateQuality() {
    	for (int i = 0; i < items.length; i++) {
    		items[i].updateSellIn();
    		items[i].updateQuality();
    	}
    }
}
