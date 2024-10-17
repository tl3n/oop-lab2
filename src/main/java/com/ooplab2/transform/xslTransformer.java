package com.ooplab2.transform;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class xslTransformer {
  public static void transform(String xmlFilePath, String xslFilePath) {
    try {
      File xmlFile = new File(xmlFilePath);
      File xslFile = new File(xslFilePath);

      File outputXML = new File(xslFile.getName().replaceFirst("[.][^.]+$", "") + "Candy.xml");

      TransformerFactory factory = TransformerFactory.newInstance();

      StreamSource xslStream = new StreamSource(xslFile);
      Transformer transformer = factory.newTransformer(xslStream);

      StreamSource xmlSource = new StreamSource(xmlFile);
      StreamResult result = new StreamResult(outputXML);

      transformer.transform(xmlSource, result);

      System.out.println("Transformation has gone successfully. Transformed file saved as: " + outputXML.getPath());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
