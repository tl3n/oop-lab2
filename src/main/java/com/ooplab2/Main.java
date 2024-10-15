package com.ooplab2;

import com.ooplab2.parsers.domParser;

import java.util.List;

public class Main {
  public static void main(String args[]) {
    List<CandyItem> candyList = domParser.parseCandy("candy.xml");

    candyList.forEach(candy -> System.out.println(candy));
  }
}
