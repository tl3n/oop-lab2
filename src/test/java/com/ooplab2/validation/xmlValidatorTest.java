package com.ooplab2.validation;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class xmlValidatorTest {

    @Test
    public void testValidateValidXML() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL xmlFile = classLoader.getResource("candy.xml");
        URL xsdFile = classLoader.getResource("candy.xsd");

        boolean isValid = xmlValidator.validateXMLSchema(xmlFile.getPath(), xsdFile.getPath());
        assertTrue(isValid, "Valid XML should be validated");
    }

    @Test
    public void testValidateInvalidXML() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL xmlFile = classLoader.getResource("invalid_candy.xml");
        URL xsdFile = classLoader.getResource("candy.xsd");

        boolean isValid = xmlValidator.validateXMLSchema(xmlFile.getPath(), xsdFile.getPath());
        assertFalse(isValid, "Invalid XML should not be validated");
    }
}
