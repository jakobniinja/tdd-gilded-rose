package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

  @Test
  void testInit() {
    assertNotNull(new GildedRose());
  }

  @ParameterizedTest
  @MethodSource("itemProvider")
  void testItemQuality(String itemName, int sellIn, int quality, int expectedQuality) {
    GildedRose gildedRose = new GildedRose(new Item[]{new Item(itemName, sellIn, quality)});
    gildedRose.updateQuality();
    assertEquals(expectedQuality, gildedRose.items[0].quality);
  }

  static Stream<Arguments> itemProvider() {
    return Stream.of(
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", 12, 4, 5),
        Arguments.of("Backstage passes to a TAFKAL80ETC concert", -100, -20, 0),
        Arguments.of("Sulfuras, Hand of Ragnaros", -100, 3, 3),
        Arguments.of("Best Aged Brie2", -100, 3, 1),
        Arguments.of("Aged Brie2", -100, -20, -20),
        Arguments.of("Aged Brie", -100, -20, -19),
        Arguments.of("Aged Brie", -100, 70, 70),
        Arguments.of("Adam's sandal", 0, 0, 0));
  }
}
