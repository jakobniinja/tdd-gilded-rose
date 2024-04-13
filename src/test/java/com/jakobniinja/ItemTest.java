package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

  private Item item;

  @BeforeEach
  void setUp() {
    item = new Item("Milk", 3, 1);
  }

  @Test
  void onInitMilk() {
    assertEquals("Milk", item.name);
  }

  @Test
  void onInitSellIn() {
    assertEquals(3, item.sellIn);
  }

  @Test
  void onInitQuality() {
    assertEquals(1, item.quality);
  }

  @Test
  void onSellInToString() {
    assertEquals(1, item.quality);
    assertEquals("Milk selling for 3$ in quality 1", item.toString());
  }

  @Test
  void onQualityToString() {
    Item item = new Item("Milk", 2, 1);
    assertEquals(1, item.quality);
    assertEquals("Milk selling for 2$ in quality 1", item.toString());
  }
}
