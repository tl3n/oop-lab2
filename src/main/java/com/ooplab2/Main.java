package com.ooplab2;

import com.ooplab2.validation.xmlValidator;

public class Main {
  public static void main(String args[]) {
    System.out.println(xmlValidator.validateXMLSchema("candy.xml", "candy.xsd"));
  }
}
