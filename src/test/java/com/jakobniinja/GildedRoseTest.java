package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  private GildedRose gildedRose;

  private Item item;

  @Test
  void testInit() {
    assertNotNull(new GildedRose());
  }

  @Test
  void testRuneQualityLessThan0() {
    item = new Item("Rune Sword", 1999, -1);
    gildedRose = new GildedRose(new Item[]{item});
    gildedRose.updateQuality();
    assertItemQuality(-1);
  }

  @Test
  void testRagnaros() {
    item = new Item("Sulfuras, Hand of Ragnaros", 1999, 4);
    gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();

    assertEquals("Sulfuras, Hand of Ragnaros", item.name);
    assertItemQuality(3);
  }

  @Test
  void testLessThan50() {
    item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4);
    gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertItemQuality(5);
  }


  @Test
  void testLessThan6() {
    item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 4);
    gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertItemQuality(7);
  }

  @Test
  void testAgedBrieLessThan50() {
    item = new Item("Aged Brie", 12, 1);
    gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertItemQuality(2);
  }

  @Test
  void testAgedBrieGreaterThan50() {
    item = new Item("Aged Brie", 12, 100);
    gildedRose = new GildedRose(new Item[]{item});

    gildedRose.updateQuality();
    assertItemQuality(100);
  }

  private void assertItemQuality(int expectedQuality) {
    assertEquals(1, gildedRose.items.length);
    assertEquals(expectedQuality, item.quality);
  }
}
