package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void testInit() {
    assertNotNull(new GildedRose());
  }

  @Test
  void testItemSize1() {
    Item item = new Item("Rune Sword", 1999, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});
    assertEquals(1, gildedRose.items.length);
  }

  @Test
  void testZeroItems() {
    GildedRose gildedRose = new GildedRose(new Item[]{});
    assertEquals(0, gildedRose.items.length);
  }

  @Test
  void testRagnaros() {
    Item item = new Item("Sulfuras, Hand of Ragnaros", 1999, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals("Sulfuras, Hand of Ragnaros", item.name);
    assertEquals(3, item.quality);
  }

  @Test
  void testUpdateQualityNotSulfuras() {
    Item item = new Item("Rune Sword", 1999, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(1999, item.sellIn);
  }

  @Test
  void testGreaterThan50() {
    Item item = new Item("Sulfuras, Hand of Ragnaros", 12, 66);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(65, item.quality);
  }

  @Test
  void testLessThan50() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(5, item.quality);
  }

  @Test
  void testLessThan11() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(6, item.quality);
  }

  @Test
  void testLessThan6() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(7, item.quality);
  }


  @Test
  void testGreaterThan12() {
    Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(5, item.quality);
  }


  @Test
  void testAgedBrie() {
    Item item = new Item("Apple", 12, 1);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(0, item.quality);
  }
}
