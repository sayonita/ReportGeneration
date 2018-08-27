package utils.xml;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import static org.hamcrest.MatcherAssert.assertThat;

public class XmlUtils {


    public static void verifyAllNodeContainsValue(String xmlFile, String tagName, String expectedValue) throws ParserConfigurationException, IOException, SAXException {
        List<String> nodeValueList = new ArrayList<String>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName(tagName);
        int nodeCount = list.getLength();
        for (int node = 0; node < nodeCount; node++) {
            nodeValueList.add(doc.getElementsByTagName(tagName).item(node).getTextContent());
        }
        assertThat(nodeValueList, not(hasItems(not(expectedValue))));


    }

    public static void verifyNodeContainsValue(String xmlFile, String tagName, String expectedValue) throws ParserConfigurationException, IOException, SAXException {
        List<String> nodeValueList = new ArrayList<String>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName(tagName);
        int nodeCount = list.getLength();
        for (int node = 0; node < nodeCount; node++) {
            nodeValueList.add(doc.getElementsByTagName(tagName).item(node).getTextContent());
        }
        assertThat(nodeValueList, hasItems(expectedValue));
    }

}
		
	


   
    

