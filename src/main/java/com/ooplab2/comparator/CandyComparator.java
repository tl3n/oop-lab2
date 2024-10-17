package com.ooplab2.comparator;

import java.util.Comparator;
import com.ooplab2.CandyItem;

public class CandyComparator implements Comparator<CandyItem> {
  @Override
  public int compare(CandyItem firstCandy, CandyItem secondCandy) {
    return firstCandy.getName().compareTo(secondCandy.getName());
  }
}
