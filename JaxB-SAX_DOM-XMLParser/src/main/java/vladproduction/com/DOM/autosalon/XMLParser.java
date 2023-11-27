package vladproduction.com.DOM.autosalon;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML data
            Document document = builder.parse(
                    new File("src/main/java/vladproduction/com/DOM/autosalon/autosalon.xml"));
            
            // Get the root element
            Element root = document.getDocumentElement();
            
            // Get the "diler" element
            Element diler = (Element) root.getElementsByTagName("diler").item(0);
            String city = diler.getAttribute("city");
            String country = diler.getAttribute("country");
            
            // Print the "diler" details
            System.out.println("Diler City: " + city);
            System.out.println("Diler Country: " + country);
            
            // Get all "car" elements
            NodeList carList = root.getElementsByTagName("car");
            
            // Loop through each "car" element
            for (int i = 0; i < carList.getLength(); i++) {
                Element car = (Element) carList.item(i);
                
                // Get the car attributes
                String category = car.getAttribute("category");
                
                // Get the car details
                String brand = car.getElementsByTagName("brand").item(0).getTextContent();
                String model = car.getElementsByTagName("model").item(0).getTextContent();
                String color = car.getElementsByTagName("color").item(0).getTextContent();
                String year = car.getElementsByTagName("year").item(0).getTextContent();
                String price = car.getElementsByTagName("price").item(0).getTextContent();

                
                // Print the car details
                System.out.println("---------------------------------------");
                System.out.println("Category: " + category);
                System.out.println("Brand: " + brand);
                System.out.println("Model: " + model);
                System.out.println("Color: " + color);
                System.out.println("Year: " + year);
                System.out.println("Price: " + price);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
