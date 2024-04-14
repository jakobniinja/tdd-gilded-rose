package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void onInit() {
    assertNotNull(new GildedRose());
  }

  @Test
  void onItemSize1() {

    Item item = new Item("Rune Sword", 1999, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});
    assertEquals(1, gildedRose.items.length);
  }

  @Test
  void onInitItemZero() {

    GildedRose gildedRose = new GildedRose(new Item[]{});
    assertEquals(0, gildedRose.items.length);
  }

  @Test
  void onUpdateQualityNotSulfuras() {

    Item item = new Item("Rune Sword", 1999, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(1998, item.sellIn);
  }

  @Test
  void onUpdateQualityLessThan50() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(5, item.quality);
  }

  @Test
  void onUpdateQualityLessThan50SellIn11() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(6, item.quality);
  }
}
