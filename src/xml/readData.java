package xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ExtentManager.ExtentTestManager;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class readData {
	static String nodeValue="";
	static Document doc=null;
	@Test(priority=2,description="get string method")
protected static String getString(String tagname) throws ParserConfigurationException, SAXException, IOException//,Element element) throws ParserConfigurationException, SAXException, IOException
	{
		//ExtentTestManager.getTest().setDescription("Validating node error code");
		File file=new File("C:\\Users\\sayoooooo\\Desktop\\hello.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList list=doc.getElementsByTagName(tagname);
		int count=list.getLength();
		System.out.println("no of nodes" + count);
		for(int i=0;i<=count-1;i++)
		{
	    nodeValue=doc.getElementsByTagName(tagname).item(i).getTextContent();
	    System.out.println(nodeValue);
	    Assert.assertFalse(nodeValue.equals("abcd"), "matched not found");
	   /* if(nodeValue.equals("abc")){
	    	System.out.println("matched node found");
	    }
	    else
	    	System.out.println("matched node not found");*/
		}
		return tagname;
	}
	@Test(priority=4,description="check parent node")	
	public String check_parent_node(String expected) throws SAXException, IOException, ParserConfigurationException
	{
		//ExtentTestManager.getTest().setDescription("Validating parent node");
		File file=new File("C:\\Users\\sayoooooo\\Desktop\\hello.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		Assert.assertEquals(doc.getDocumentElement().getNodeName(), expected);
		return expected;
	}
	
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	@Test(priority=1,description="call getString method")
	public void call() throws ParserConfigurationException, SAXException, IOException
		{
		ExtentTestManager.getTest().setDescription("calling the validate node method");;
			getString("screen");	
			
		}
	@Test(priority=4,description="call parent node")	
	public void chck() throws SAXException, IOException, ParserConfigurationException
	{
		//ExtentTestManager.getTest().setDescription("calling the parent node method");;
		String node=check_parent_node("company") ;
	}
}
		
	


   
    

