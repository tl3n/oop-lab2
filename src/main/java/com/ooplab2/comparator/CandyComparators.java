package com.ooplab2.comparator;

import java.util.Comparator;
import com.ooplab2.CandyItem;

public class CandyComparators {

  public static Comparator<CandyItem> byName() {
    return Comparator.comparing(CandyItem::getName);
  }

  public static Comparator<CandyItem> byEnergy() {
    return Comparator.comparing(CandyItem::getEnergy);
  }

  public static Comparator<CandyItem> byProduction() {
    return Comparator.comparing(CandyItem::getProduction);
  }
}
