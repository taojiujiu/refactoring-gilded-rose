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
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
        ) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }

            if (item.sell_in < 0) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
            }
        } else {
            if(item.name.equals("Aged Brie")){
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                updatedBackstageRoseQuality(item);
            }
        }
    }

    private void updatedBackstageRoseQuality(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sell_in < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sell_in < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sell_in < 0) {
                item.quality = item.quality - item.quality;
            }
        }
    }
}
