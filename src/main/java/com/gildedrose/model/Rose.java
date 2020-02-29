package com.gildedrose.model;

public class Rose {

    public String name;

    public int sellIn;

    public int quality;

    public Rose(String name, int sell_in, int quality) {
        this.name = name;
        this.sellIn = sell_in;
        this.quality = quality;
    }

    public void updateQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
            if (this.sellIn < 0) {
                this.quality = this.quality - 1;
            }
        }
    }

    public void updateSellIn() {
        this.sellIn--;
    }
}
