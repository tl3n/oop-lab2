package com.ooplab2.parsers;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import com.ooplab2.CandyItem;


public class domParser {
  public static List<CandyItem> parseCandy(String xmlFile) {
    List<CandyItem> candyList = new ArrayList<>();
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File(xmlFile));
      document.getDocumentElement().normalize();

      NodeList nodeList = document.getElementsByTagName("CandyItem");

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);

        //System.out.println("\nCurrent Element: " + node.getNodeName());

        if(node.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) node;

          CandyItem candy = new CandyItem();
          candy.setId(element.getAttribute("id"));
          candy.setType(element.getAttribute("type"));
          candy.setFilling(Boolean.parseBoolean(element.getAttribute("filling")));
          candy.setName(element.getElementsByTagName("Name").item(0).getTextContent());
          candy.setEnergy(Integer.parseInt(element.getElementsByTagName("Energy").item(0).getTextContent()));

          NodeList ingredientsList = element.getElementsByTagName("Ingredient");
          List<String> ingredients = new ArrayList<>();
          for (int j = 0; j < ingredientsList.getLength(); j++) {
            ingredients.add(ingredientsList.item(j).getTextContent());
          }

          candy.setIngredients(ingredients);

          candy.setProteins(Float.parseFloat(element.getElementsByTagName("Proteins").item(0).getTextContent()));
          candy.setFats(Float.parseFloat(element.getElementsByTagName("Fats").item(0).getTextContent()));
          candy.setCarbohydrates(Float.parseFloat(element.getElementsByTagName("Carbohydrates").item(0).getTextContent()));
          candy.setProduction(element.getElementsByTagName("Production").item(0).getTextContent());

          //System.out.println(candy);

          candyList.add(candy);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return candyList;
  }
}
