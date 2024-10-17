package com.ooplab2;

import com.ooplab2.transform.xslTransformer;
import java.net.URL;

public class Main {
  public static void main(String args[]) {
    //System.out.println(xmlValidator.validateXMLSchema("candy.xml", "candy.xsd"));

    ClassLoader classLoader = Main.class.getClassLoader();

    URL xmlFile = classLoader.getResource("candy.xml");
    URL byTypeXSL = classLoader.getResource("byType.xsl");
    URL byProductionXSL = classLoader.getResource("byProduction.xsl");
    URL byFillingXSL = classLoader.getResource("byFilling.xsl");

    xslTransformer.transform(xmlFile.getPath(), byTypeXSL.getPath());
    xslTransformer.transform(xmlFile.getPath(), byProductionXSL.getPath());
    xslTransformer.transform(xmlFile.getPath(), byFillingXSL.getPath());
  }
}
