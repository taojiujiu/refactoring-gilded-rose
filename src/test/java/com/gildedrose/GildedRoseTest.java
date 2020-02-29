package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Rose[] roses = new Rose[] { new Rose("foo", 1, 5) };
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("foo", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality, is(4));
        assertThat(gildedRose.roses[0].sell_in, is(0));
    }



    @Test
    public void should_quality_subtract_1_when_update_quality_given_normal_rose(){
        Rose[] roses = new Rose[]{new Rose("normal rose",2,3)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("normal rose", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality, is(2));
    }

    @Test
    public void should_quality_add_1_when_updated_quality_given_Aged_Brie_reose_and_quality_is_49(){
        Rose[] roses = new Rose[]{new Rose("Aged Brie",2,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality, is(50));
    }

    @Test
    public void should_quality_not_change_when_updated_quality_given_Sulfuras_and_of_Ragnaros_and_quality_less_than_50(){
        Rose[] roses = new Rose[]{new Rose("Sulfuras, Hand of Ragnaros",2,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(49));
    }

    @Test
    public void should_quality_add_2_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_less_than_49_sell_less_than_11_and_bigger_than_6(){
        Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert",8,4)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(6));
    }

    @Test
    public void should_quality_add_3_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_less_than_49_sell_less_than_6(){
        Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert",5,4)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality, is(7));
    }

    @Test
    public void should_quality_add_1_when_updated_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_is_49_sell_less_than_11(){
        Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert",2,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(50));
    }

    @Test
    public void should_sell_subtract_1_when_update_sell_given_normal_rose_concert_rose(){
        Rose[] roses = new Rose[]{new Rose("normal",4,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("normal", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].sell_in, is(3));
    }

    @Test
    public void should_sell_subtract_1_when_update_sell_given_Backstage_passes_to_a_TAFKAL80ETC_concert_rose(){
        Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert",4,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertThat(gildedRose.roses[0].sell_in, is(3));
    }

    @Test
    public void should_sell_subtract_1_when_update_sell_given_Aged_Brie_concert_rose(){
        Rose[] roses = new Rose[]{new Rose("Aged Brie",4,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].sell_in,is(3));
    }

    @Test
    public void should_quality_add_2__when_update_quality_given_Aged_Brie_concert_rose_and_sell_less_than_0_and_quality_less_than_49(){
        Rose[] roses = new Rose[]{new Rose("Aged Brie",-1,44)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(46));
    }

    @Test
    public void should_quality_not_change_when_update_quality_given_Aged_Brie_concert_rose_and_sell_less_than_0_and_quality_more_than_49(){
        Rose[] roses = new Rose[]{new Rose("Aged Brie",-1,50)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Aged Brie", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(50));
    }

    @Test
    public void should_quality_set_0_when_update_quality_given_Backstage_passes_to_a_TAFKAL80ETC_concert_rose_and_sell_less_than_0(){
        Rose[] roses = new Rose[]{new Rose("Backstage passes to a TAFKAL80ETC concert",-1,49)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertThat(gildedRose.roses[0].quality,is(0));
    }

    @Test
    public void should_quality_not_change_when_update_quality_given_Sulfuras_Hand_of_Ragnaros_concert_rose_and_sell_less_than_0_and_quality_more_than_1(){
        Rose[] roses = new Rose[]{new Rose("Sulfuras, Hand of Ragnaros",-1,2)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(2));
    }

    @Test
    public void should_quality_not_change_when_update_quality_given_normal_rose_and_sell_less_than_0_and_quality_more_than_1(){
        Rose[] roses = new Rose[]{new Rose("normal",-1,5)};
        GildedRose gildedRose = new GildedRose(roses);
        gildedRose.update_quality();
        assertEquals("normal", gildedRose.roses[0].name);
        assertThat(gildedRose.roses[0].quality,is(3));
    }

}
