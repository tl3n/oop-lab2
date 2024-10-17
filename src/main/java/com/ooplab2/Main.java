package com.ooplab2;

import com.ooplab2.transform.xslTransformer;

public class Main {
  public static void main(String args[]) {
    //System.out.println(xmlValidator.validateXMLSchema("candy.xml", "candy.xsd"));

    xslTransformer.transform("candy.xml","byType.xsl");
    xslTransformer.transform("candy.xml","byProduction.xsl");
    xslTransformer.transform("candy.xml","byFilling.xsl");
  }
}
