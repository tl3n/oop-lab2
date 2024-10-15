package com.ooplab2.parsers;

import com.ooplab2.CandyItem;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class domParserTest {
  @Test
  public void testParseCandy() {
      List<CandyItem> candyList = domParser.parseCandy("candy.xml");
      assertEquals(2, candyList.size());
      assertEquals("ChocoDelight", candyList.get(0).getName());
  }
}
