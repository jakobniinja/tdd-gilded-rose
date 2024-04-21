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
  void testLessThan50() {
    item = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4);
    assertItemQuality(4);
  }

  @Test
  void testSellInNegative() {
    item = new Item("Aged Brie", -100, -20);
    assertItemQuality(-19);
  }

  @Test
  void testSellInMismatchName() {
    item = new Item("Aged Brie2", -100, -20);
    assertItemQuality(-21);
  }

  @Test
  void testSellInMismatchBackstage() {
    item = new Item("Backstage passes to a TAFKAL80ETC concert", -100, -20);
    assertItemQuality(0);
  }

  @Test
  void testSellInNegativeGreater() {
    item = new Item("Aged Brie", -100, 70);
    assertItemQuality(69);
  }

  private void assertItemQuality(int expectedQuality) {
    gildedRose = new GildedRose(new Item[]{item});
    gildedRose.updateQuality();
    assertEquals(1, gildedRose.items.length);
    assertEquals(expectedQuality, item.quality);
  }

  @Test
  void testSellInQuality() {
    item = new Item("Best Aged Brie2", -100, 3);
    assertItemQuality(0);
  }

  @Test
  void testSellInQualitySulfuras() {
    item = new Item("Sulfuras, Hand of Ragnaros", -100, 3);
    assertItemQuality(3);
  }
}
