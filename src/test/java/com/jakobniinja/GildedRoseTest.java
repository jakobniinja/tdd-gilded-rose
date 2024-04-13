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
}
