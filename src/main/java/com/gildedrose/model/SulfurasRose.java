package com.gildedrose.model;


import com.gildedrose.exception.IllegalUpdateException;

public class SulfurasRose extends Rose {
    public SulfurasRose(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateSellIn() {
        throw new IllegalUpdateException("Could not update this rose: " + this.name);
    }

    @Override
    public void updateQuality() {
        throw new IllegalUpdateException("Could not update this rose: " + this.name);
    }
}
