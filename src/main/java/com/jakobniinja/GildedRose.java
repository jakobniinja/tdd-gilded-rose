package com.jakobniinja;

public class GildedRose {

  Item[] items;

  public GildedRose() {
  }

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sellIn -= 1;
      }
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
          }
        }
      }
    }
  }
}
