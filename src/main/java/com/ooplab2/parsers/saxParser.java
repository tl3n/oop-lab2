package com.ooplab2.parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ooplab2.CandyItem;

public class saxParser {
  public static List<CandyItem> parseCandy(String xmlFile) {
    List<CandyItem> candyList = new ArrayList<>();
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser parser = factory.newSAXParser();

      DefaultHandler handler = new DefaultHandler() {
        CandyItem candy;
        boolean isName = false;
        boolean isEnergy = false;
        boolean isProteins = false;
        boolean isFats = false;
        boolean isCarbohydrates = false;
        boolean isProduction = false;
        boolean isIngredient = false;
        List<String> ingredients = new ArrayList<>();
      
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          if (qName.equalsIgnoreCase("CandyItem")) {
            candy = new CandyItem();
            candy.setId(attributes.getValue("id"));
            candy.setType(attributes.getValue("type"));
            candy.setFilling(Boolean.parseBoolean(attributes.getValue("filling")));
          } else if (qName.equalsIgnoreCase("Name")) {
            isName = true;
          } else if (qName.equalsIgnoreCase("Energy")) {
            isEnergy = true;
          } else if (qName.equalsIgnoreCase("Ingredient")) {
            isIngredient = true;
          } else if (qName.equalsIgnoreCase("Proteins")) {
            isProteins = true;
          } else if (qName.equalsIgnoreCase("Fats")) {
            isFats = true;
          } else if (qName.equalsIgnoreCase("Carbohydrates")) {
            isCarbohydrates = true;
          } else if (qName.equalsIgnoreCase("Production")) {
            isProduction = true;
          }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
          if (isName) {
            candy.setName(new String(ch, start, length));
            isName = false;
          } else if (isEnergy) {
            candy.setEnergy(Integer.parseInt(new String(ch, start, length)));
            isEnergy = false;
          } else if (isIngredient) {
            ingredients.add(new String(ch, start, length));
            isIngredient = false;
          } else if (isProteins) {
            candy.setProteins(Float.parseFloat(new String(ch, start, length)));
            isProteins = false;
          } else if (isFats) {
            candy.setFats(Float.parseFloat(new String(ch, start, length)));
            isFats = false;
          } else if (isCarbohydrates) {
            candy.setCarbohydrates(Float.parseFloat(new String(ch, start, length)));
            isCarbohydrates = false;
          } else if (isProduction) {
            candy.setProduction(new String(ch, start, length));
            isProduction = false;
          }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
          if (qName.equalsIgnoreCase("CandyItem")) {
            candy.setIngredients(ingredients);
            candyList.add(candy);
            ingredients = new ArrayList<>();
          }
        }
      };
      parser.parse(xmlFile, handler);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return candyList;
  }
}
