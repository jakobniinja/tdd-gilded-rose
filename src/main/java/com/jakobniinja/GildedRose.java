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
      if (item.name.equals("Aged Brie")) {
        if (item.quality < 50) {
          item.quality++;
        }
      } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        item.quality++;
        if (item.sellIn < 11) {
          item.quality++;
        }
        if (item.sellIn < 6) {
          item.quality++;
        }
        if (item.sellIn < 0) {
          item.quality = 0;
        }
      } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        if (item.quality > 0) {
          item.quality--;
        }
        if (item.sellIn < 0 && item.quality > 0) {
          item.quality--;
        }
      }
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sellIn--;
      }
    }
  }
}
