package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (Item item : items) {
            updatedSellByName(item);
            updatedQuality(item);
        }
    }

    private void updatedSellByName(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sell_in = item.sell_in - 1;
        }
    }

    private void updatedQuality(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
            case "Aged Brie":
                if (item.sell_in < 0 && item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                return;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    updatedBackstageRoseQuality(item);
                }
                return;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                    if (item.sell_in < 0) {
                        item.quality = item.quality - 1;
                    }
                }
        }
    }

    private void updatedBackstageRoseQuality(Item item) {

        if (item.quality < 50) {
            if (item.sell_in < 11) {
                item.quality = item.quality + 1;
            }
        }

        if (item.quality < 50) {
            if (item.sell_in < 6) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sell_in < 0) {
            item.quality = item.quality - item.quality;
        }
    }
}
