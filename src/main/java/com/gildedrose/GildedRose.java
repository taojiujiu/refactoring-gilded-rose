package com.gildedrose;

class GildedRose {
    Rose[] roses;

    public GildedRose(Rose[] roses) {
        this.roses = roses;
    }

    public void update_quality() {
        for (Rose rose : roses) {
            updatedSellByName(rose);
            updatedQuality(rose);
        }
    }

    private void updatedSellByName(Rose rose) {
        if (!rose.name.equals("Sulfuras, Hand of Ragnaros")) {
            rose.sell_in = rose.sell_in - 1;
        }
    }

    private void updatedQuality(Rose rose) {
        switch (rose.name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
            case "Aged Brie":
                if (rose.sell_in < 0 && rose.quality < 50) {
                    rose.quality = rose.quality + 1;
                }
                if (rose.quality < 50) {
                    rose.quality = rose.quality + 1;
                }
                return;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (rose.quality < 50) {
                    rose.quality = rose.quality + 1;
                    updatedBackstageRoseQuality(rose);
                }
                return;
            default:
                if (rose.quality > 0) {
                    rose.quality = rose.quality - 1;
                    if (rose.sell_in < 0) {
                        rose.quality = rose.quality - 1;
                    }
                }
        }
    }

    private void updatedBackstageRoseQuality(Rose rose) {
        if (rose.quality < 50) {
            if (rose.sell_in < 6) rose.quality = rose.quality + 2;
            else if (rose.sell_in < 11) rose.quality = rose.quality + 1;
        }

        if (rose.sell_in < 0) {
            rose.quality = 0;
        }
    }
}
