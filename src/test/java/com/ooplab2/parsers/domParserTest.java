package com.ooplab2.parsers;

import com.ooplab2.CandyItem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class domParserTest {

    @Test
    public void testParseCandy() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL xmlFile = classLoader.getResource("candy.xml");

        List<CandyItem> candyList = domParser.parseCandy(xmlFile.getPath());

        assertEquals(10, candyList.size(), "Candy list should be size of 10");

        CandyItem firstCandy = candyList.get(0);
        assertEquals("ChocoDelight", firstCandy.getName(), "1st candy should be 'ChocoDelight'");
        assertEquals(250, firstCandy.getEnergy(), "1st candy's energy should be 250");
    }
}
