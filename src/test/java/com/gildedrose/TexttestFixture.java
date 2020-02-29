package com.gildedrose;

import com.gildedrose.model.Rose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Rose[] roses = new Rose[] {
                new Rose("+5 Dexterity Vest", 10, 20), //
                new Rose("Aged Brie", 2, 0), //
                new Rose("Elixir of the Mongoose", 5, 7), //
                new Rose("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Rose("Sulfuras, Hand of Ragnaros", -1, 80),
                new Rose("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Rose("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Rose("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Rose("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Rose("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(roses);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Rose rose : roses) {
                System.out.println(rose);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
