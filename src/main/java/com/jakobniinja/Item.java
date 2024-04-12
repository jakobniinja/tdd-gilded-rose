package com.jakobniinja;

public class Item {

  public String name;

  public int sellIn;

  public int quality;


  public Item() {
  }

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return "Milk selling for 3$ in best quality";
  }
}
