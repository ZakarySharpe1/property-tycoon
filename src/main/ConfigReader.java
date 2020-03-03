package main;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {

    private ArrayList<Map> tileList;

    public ArrayList<Map> ConfigReader() {


        tileList = new ArrayList<>();
        try {

            File file = new File("resources/config/property-property-config.xml");

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

                    ArrayList<String> elements = new ArrayList<>();

                    try {
                        switch (eElement.getElementsByTagName("type").item(0).getTextContent()) {

                            case "property":
                                elements.addAll(Arrays.asList("name", "type", "cost", "one-house", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "go":
                                elements.addAll(Arrays.asList("name", "type", "cost", "one-house", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "jail":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "tax":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "chest":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "station":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "parking":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "gotojail":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;
                            case "random":
                                elements.addAll(Arrays.asList("name", "type", "cost", "two-house", "three-house", "four-house", "hotel", "colour"));
                                break;

                        }

                        for (String ele : elements) {
                            dictionary.put(ele, eElement.getElementsByTagName(ele).item(0).getTextContent());
                        }

                    } catch (Exception e) {

                        System.out.println("error in config file setup");

                    }


                    tileList.add(dictionary);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tileList;

    }


}
