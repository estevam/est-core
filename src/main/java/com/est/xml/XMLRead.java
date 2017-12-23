package com.est.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author estevam
 */
public class XMLRead {

    private static String path = "/Users/estevam/NetBeansProjects/est-framework/src/java/com/est/xml/MatrixConfig.xml";
  
    public static void main(String[] args) throws Exception {

        System.out.println("testAttr for root element: ");
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = (Document) builder.parse(new File(path));

        Element rootElement = doc.getDocumentElement();
        System.out.println("testAttr for root element: "
                + rootElement.getAttribute("myworld="));

        System.out.println("myworld: "
                + rootElement.getAttribute("myworld"));



        NodeList list = rootElement.getElementsByTagName("appMyworld");

        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            System.out.println("list number " + i + ": " + childNode.getTextContent());
        }
    }
}
