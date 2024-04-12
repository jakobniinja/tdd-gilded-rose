package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private static final String[] args = new String[]{"hi"};

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void onInit() {
    assertNotNull(new Main());
  }

  @Test
  void onGetArgs() {
    Main.main(args);
    assertEquals("Hello world!", outContent.toString());
  }
}