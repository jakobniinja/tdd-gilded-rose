package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ItemTest {

  @Test
  void onInit() {
    assertNotNull(new Item());
  }

  @Test
  void onThreeArgumentConstructorName() {
    Item item = new Item("Milk", 3, 1);
    assertEquals("Milk", item.name);
  }

  @Test
  void onThreeArgumentConstructorSellIn() {
    Item item = new Item("Milk", 3, 1);
    assertEquals(3, item.sellIn);
  }

  @Test
  void onThreeArgumentConstructor() {
    Item item = new Item("Milk", 3, 1);
    assertEquals(1, item.quality);
  }

  @Test
  void onToString() {
    String item = new Item().toString();
    assertEquals("Milk selling for 3$ in best quality", item);
  }
}
