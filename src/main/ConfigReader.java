package main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {

    private ArrayList<Map> tileList ;

    public ArrayList<Map> ConfigReader() {


        tileList = new ArrayList<>();
        try {

            File file = new File("resources/config/config.xml");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("tile");


            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node nNode = nodeList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Map<String, String> dictionary = new HashMap<>();

                    Element eElement = (Element) nNode;


                    dictionary.put("name",eElement.getElementsByTagName("name").item(0).getTextContent());
                    dictionary.put("type", eElement.getElementsByTagName("type").item(0).getTextContent());
                    dictionary.put("cost",eElement.getElementsByTagName("cost").item(0).getTextContent());
                    dictionary.put("one-house",eElement.getElementsByTagName("one-house").item(0).getTextContent());
                    dictionary.put("two-house",eElement.getElementsByTagName("two-house").item(0).getTextContent());
                    dictionary.put("three-house",eElement.getElementsByTagName("three-house").item(0).getTextContent());
                    dictionary.put("four-house",eElement.getElementsByTagName("four-house").item(0).getTextContent());
                    dictionary.put("hotel",eElement.getElementsByTagName("hotel").item(0).getTextContent());
                    dictionary.put("colour",eElement.getElementsByTagName("colour").item(0).getTextContent());

                    tileList.add(dictionary);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tileList;

    }


}
