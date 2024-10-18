package com.ooplab2.comparator;

import com.ooplab2.CandyItem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.util.Collections.sort;

public class CandySorterTest {

    @Test
    public void testSortByName() {
        List<CandyItem> candyList = createCandyList();
        sort(candyList, CandyComparators.byName());

        assertEquals("CaramelDream", candyList.get(0).getName());
        assertEquals("ChocoDelight", candyList.get(1).getName());
    }

    @Test
    public void testSortByEnergy() {
        List<CandyItem> candyList = createCandyList();
        sort(candyList, CandyComparators.byEnergy());

        assertEquals(150, candyList.get(0).getEnergy());
        assertEquals(250, candyList.get(1).getEnergy());
    }

    @Test
    public void testSortByProduction() {
        List<CandyItem> candyList = createCandyList();
        sort(candyList, CandyComparators.byProduction());

        assertEquals("CaramelKing", candyList.get(0).getProduction());
        assertEquals("SweetFactory", candyList.get(1).getProduction());
    }

    private List<CandyItem> createCandyList() {
        List<CandyItem> candyList = new ArrayList<>();
        candyList.add(new CandyItem("c1", "ChocoDelight", 250, "SweetFactory"));
        candyList.add(new CandyItem("c2", "CaramelDream", 150, "CaramelKing"));
        return candyList;
    }
}
