package vladproduction.com.SAX.cars;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyDefaultHandler extends DefaultHandler {

    private Car car;
    private List<Car> cars;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument()");
        cars = new ArrayList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.setLength(0);
        if("autoSalon".equals(qName)){
            String city = attributes.getValue("City");
            String country = attributes.getValue("Country");
            sb.append(city+", ");
            sb.append(country);
            System.out.println("[autoSalon]  "+sb);
        }
        if("auto".equals(qName)){
            car = new Car();
            String year = attributes.getValue("Year");
            sb.append(year);
            System.out.println("Year: "+sb);
        }
        if("price".equals(qName)){
            String currency = attributes.getValue("currency");
            sb.append("("+currency+")");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("auto".equals(qName)){
            cars.add(car);
        }
        if(qName.equalsIgnoreCase("name")){
            System.out.printf("name: %s%n",sb.toString());
            String name = sb.toString();
            car.setName(name);
        }
        if(qName.equalsIgnoreCase("model")){
            System.out.printf("model: %s%n",sb.toString());
            String model = sb.toString();
            car.setModel(model);
        }
        if(qName.equalsIgnoreCase("color")){
            System.out.printf("color: %s%n",sb.toString());
            String color = sb.toString();
            car.setColor(color);
        }
        if(qName.equalsIgnoreCase("price")){
            System.out.printf("price: %s%n",sb.toString());
            String price = sb.toString();
            car.setPrice(price);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument()");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }
}
