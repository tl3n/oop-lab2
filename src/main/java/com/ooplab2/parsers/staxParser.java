package com.ooplab2.parsers;

import com.ooplab2.CandyItem;
import java.util.List;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;

public class staxParser {
  public static List<CandyItem> parseCandy(String xmlFile) {
    List<CandyItem> candyList = new ArrayList<>();
    try {
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(xmlFile));

      CandyItem candy = null;
      List<String> ingredients = new ArrayList<>();

      while (eventReader.hasNext()) {
        XMLEvent event = eventReader.nextEvent();

        if (event.isStartElement()) {
          String localPart = event.asStartElement().getName().getLocalPart();
          switch (localPart) {
            case "CandyItem":
              candy = new CandyItem();
              candy.setId(event.asStartElement().getAttributeByName(new QName("id")).getValue());
              candy.setType(event.asStartElement().getAttributeByName(new QName("type")).getValue());
              candy.setFilling(
                  Boolean.parseBoolean(event.asStartElement().getAttributeByName(new QName("filling")).getValue()));
              break;
            case "Name":
              candy.setName(eventReader.nextEvent().asCharacters().getData());
              break;
            case "Energy":
              candy.setEnergy(Integer.parseInt(eventReader.nextEvent().asCharacters().getData()));
              break;
            case "Ingredient":
              ingredients.add(eventReader.nextEvent().asCharacters().getData());
              break;
            case "Proteins":
              candy.setProteins(Float.parseFloat(eventReader.nextEvent().asCharacters().getData()));
              break;
            case "Fats":
              candy.setFats(Float.parseFloat(eventReader.nextEvent().asCharacters().getData()));
              break;
            case "Carbohydrates":
              candy.setCarbohydrates(Float.parseFloat(eventReader.nextEvent().asCharacters().getData()));
              break;
            case "Production":
              candy.setProduction(eventReader.nextEvent().asCharacters().getData());
              break;
          }
        }

        if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("CandyItem")) {
          candy.setIngredients(ingredients);
          candyList.add(candy);
          ingredients = new ArrayList<>();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return candyList;
  }
}
