package com.ooplab2.parsers;

import com.ooplab2.CandyItem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class staxParserTest {

    @Test
    public void testParseCandy() {
        // Завантажуємо XML для тестування
        ClassLoader classLoader = getClass().getClassLoader();
        URL xmlFile = classLoader.getResource("candy.xml");

        // Парсимо XML за допомогою StAX
        List<CandyItem> candyList = staxParser.parseCandy(xmlFile.getPath());

        // Перевіряємо розмір списку
        assertEquals(10, candyList.size(), "Candy list should be size of 10");

        // Перевіряємо третій елемент
        CandyItem thirdCandy = candyList.get(2);
        assertEquals("IrisToffee", thirdCandy.getName(), "3rd candy should be 'IrisToffee'");
        assertEquals(180, thirdCandy.getEnergy(), "3rd candy's energy should be 180");
    }
}
