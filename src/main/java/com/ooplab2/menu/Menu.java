package com.ooplab2.menu;

import com.ooplab2.parsers.*;
import com.ooplab2.transform.xslTransformer;
import com.ooplab2.CandyItem;
import com.ooplab2.comparator.CandyComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ooplab2.validation.xmlValidator;

public class Menu {
  private InputReader inputReader;
  private String xmlFilePath;
  private String xsdFilePath;
  List<CandyItem> candyList;

  public Menu() {
    this.inputReader = new InputReader();
    this.xmlFilePath = getClass().getClassLoader().getResource("candy.xml").getPath();
    this.xsdFilePath = getClass().getClassLoader().getResource("candy.xsd").getPath();
    candyList = new ArrayList<>();
  }

  public void start() {
    System.out.println("Validating XML file...");
    if (!xmlValidator.validateXMLSchema(xmlFilePath, xsdFilePath)) {
      System.out.println("Validation failed");
      System.exit(-1);
    }
    System.out.println("XML validated successfully!");

    String options = "\n1. Parse" +
        "\n2. Transform using XSL" +
        "\n3. Print candy list" +
        "\n4. Sort candy list" +
        "\n0. Exit\n";


      while (true) {
      System.out.println(options);

      int choice = inputReader.readInt();
      this.printOptions(choice);
      switch (choice) {
        case 1:
          int parseChoice = inputReader.readInt();
          this.parseOptions(parseChoice);
          break;
        case 2:
          int tranformChoice = inputReader.readInt();
          this.transformOptions(tranformChoice);
          break;
        case 3:
          if (candyList.size() == 0) {
            System.out.println("Candy list is empty!");
            break;
          }
          candyList.forEach(candy -> System.out.println(candy + "\n"));
          break;
        case 4:
          if (candyList.size() == 0) {
            break;
          }
          int sortChoice = inputReader.readInt();
          this.sortOptions(sortChoice);
          break;
        case 0:
          System.out.println("Closing...");
          System.exit(0);
        default:
          break;
      }
    }
  }

  private void printOptions(int choice) {
    String options = "";
    switch (choice) {
      case 1:
        options = "\nParse using:" +
            "\n1. DOM" +
            "\n2. SAX" +
            "\n3. StAX" +
            "\n4. Return\n";
        break;
      case 2:
        options = "\nTransform by:" +
            "\n1. Type" +
            "\n2. Filling (true/false)" +
            "\n3. Production" +
            "\n4. Return\n";
        break;
      case 4:
        if (candyList.size() == 0) {
          System.out.println("Candy list is empty!");
          break;
        }
        options = "\nSort by:" +
            "\n1. Name" +
            "\n2. Energy" +
            "\n3. Production";
      default:
        break;
    }
    System.out.println(options);
  }

  private void parseOptions(int choice) {
    switch (choice) {
      case 1:
        System.out.println("Parsing using DOM...");
        try {
          candyList = domParser.parseCandy(xmlFilePath);
        } catch (Exception e) {
          System.out.println("Parsing failed");
          e.printStackTrace();
        }
        System.out.println("Parsed successfully");
        break;
      case 2:
        System.out.println("Parsing using SAX...");
        try {
          candyList = saxParser.parseCandy(xmlFilePath);
        } catch (Exception e) {
          System.out.println("Parsing failed");
          e.printStackTrace();
        }
        System.out.println("Parsed successfully");
        break;
      case 3:
        System.out.println("Parsing using StAX...");
        try {
          candyList = staxParser.parseCandy(xmlFilePath);
        } catch (Exception e) {
          System.out.println("Parsing failed");
          e.printStackTrace();
        }
        System.out.println("Parsed successfully");
        break;
      case 4:
        break;
      default:
        break;
    }
  }

  private void transformOptions(int choice) {
    String xslFilePath = "";
    String text = "";
    switch (choice) {
      case 1:
        text = "type";
        xslFilePath = getClass().getClassLoader().getResource("byType.xsl").getPath();
        break;
      case 2:
        text = "filling (true/false)";
        xslFilePath = getClass().getClassLoader().getResource("byFilling.xsl").getPath();
        break;
      case 3:
        text = "production";
        xslFilePath = getClass().getClassLoader().getResource("byProduction.xsl").getPath();
        break;
      case 4:
        break;
      default:
        break;
    }
    if (text != "") {
      System.out.println("Transforming by " + text + "...");
      this.transform(xmlFilePath, xslFilePath);
    }

  }

  private void transform(String xmlFilePath, String xslFilePath) {
    String outputXMLFilePath = xslTransformer.transform(xmlFilePath, xslFilePath);
    if (outputXMLFilePath == "") {
      System.out.println("Transformation failed");
    } else {
      System.out.println("Transformed successfully. File can be found at " + outputXMLFilePath);
    }
  }

  private void sortOptions(int choice) {
    String text = "";
    switch (choice) {
      case 1:
        text = "name";
         Collections.sort(candyList, CandyComparators.byName());
         break;
      case 2:
        text = "energy";
        Collections.sort(candyList, CandyComparators.byEnergy());
        break;
      case 3:
        text = "produciton";
        Collections.sort(candyList, CandyComparators.byProduction());
        break;
      default:
        break;
      }
    System.out.println("Sorting by " + text + "...");
  }
}
