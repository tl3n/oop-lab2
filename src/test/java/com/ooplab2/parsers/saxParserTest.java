package com.ooplab2.parsers;

import com.ooplab2.CandyItem;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class saxParserTest {
    @Test
    public void testParseCandy() {
        List<CandyItem> candyList = saxParser.parseCandy("candy.xml");
        assertEquals(2, candyList.size());
        assertEquals("CaramelDream", candyList.get(1).getName());
    }
}