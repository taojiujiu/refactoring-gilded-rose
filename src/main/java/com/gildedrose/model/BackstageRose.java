package com.gildedrose.model;

public class BackstageRose extends Rose {
    public BackstageRose(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
            if (this.quality < 50) {
                if (this.sellIn < 6) this.quality = this.quality + 2;
                else if (this.sellIn < 11) this.quality = this.quality + 1;
            }

            if (this.sellIn < 0) {
                this.quality = 0;
            }
        }
    }


}
