package com.gildedrose;

import com.gildedrose.model.AgedRose;
import com.gildedrose.model.BackstageRose;
import com.gildedrose.model.Rose;
import com.gildedrose.model.SulfurasRose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    List<Rose> roses;

    public GildedRose(Rose[] roses) {
        this.roses = Arrays.stream(roses)
                .map(this :: createRose)
                .collect(Collectors.toList());
    }

    public void updateQuality() {
        roses.stream()
                .filter(rose -> !(rose instanceof SulfurasRose))
                .forEach(rose -> {
                    rose.updateSellIn();
                    rose.updateQuality();
                });
    }

    private Rose createRose(Rose rose) {
        switch (rose.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasRose(rose.name, rose.sellIn, rose.quality);
            case "Aged Brie":
                return new AgedRose(rose.name, rose.sellIn, rose.quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageRose(rose.name, rose.sellIn, rose.quality);
            default:
                return new Rose(rose.name, rose.sellIn, rose.quality);
        }
    }
}
