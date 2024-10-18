package com.ooplab2.parsers;

import com.ooplab2.CandyItem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class saxParserTest {

    @Test
    public void testParseCandy() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL xmlFile = classLoader.getResource("candy.xml");

        List<CandyItem> candyList = saxParser.parseCandy(xmlFile.getPath());

        assertEquals(10, candyList.size(), "Candy list should be size of 10");

        // Перевіряємо другий елемент
        CandyItem secondCandy = candyList.get(1);
        assertEquals("CaramelDream", secondCandy.getName(), "2nd candy should be 'CaramelDream'");
        assertEquals(150, secondCandy.getEnergy(), "2nd candy's energy should be 150");
    }
}
