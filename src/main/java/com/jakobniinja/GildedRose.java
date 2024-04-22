package com.jakobniinja;

public class GildedRose {

  private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  private static final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";

  private static final String AGED_BRIE = "Aged Brie";

  Item[] items;

  public GildedRose() {
  }

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (item.name.equals(AGED_BRIE)) {
        if (item.quality < 50) {
          item.quality++;
        }
      } else if (item.name.equals(BACKSTAGE_PASS)) {
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
      } else if (!item.name.equals(SULFURAS_HAND)) {
        if (item.quality > 0) {
          item.quality--;
        }
        if (item.sellIn < 0 && item.quality > 0) {
          item.quality--;
        }
      }
      if (!item.name.equals(SULFURAS_HAND)) {
        item.sellIn--;
      }
    }
  }
}
