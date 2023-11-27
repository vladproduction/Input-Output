package vladproduction.com.SAX.autosalon;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

// Create a handler class for SAX events
public class MyHandler extends DefaultHandler {

    private List<Car> cars;

    private Car car;

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        cars = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        sb.setLength(0);
        if ("autosalon".equals(qName)) {
            String autosalon = attributes.getValue("autosalon");
            sb.append("Autosalon: ").append(autosalon);
            sb.append("\n===================");
            System.out.println(sb);
        }
        if ("carCenter".equals(qName)) {
            String city = attributes.getValue("city");
            String country = attributes.getValue("country");
            sb.append("\tCar center ").append("\n-city: ").append(city).append("\n-country: ").append(country);
            sb.append("\n===================");
            System.out.println(sb);

        }
        if ("car".equals(qName)) {
            car = new Car();
            String category = attributes.getValue("category");
            sb.append("\n\tcategory: ").append(category).append("\n\t------------");
            System.out.println(sb);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length);
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if ("car".equals(qName)) {
            cars.add(car);
        }
        if ("brand".equals(qName)) {
            System.out.println("brand: " + sb);
            String brand = sb.toString();
            car.setBrand(brand);
        }
        if ("model".equals(qName)) {
            System.out.println("model: " + sb);
            String model = sb.toString();
            car.setModel(model);
        }
        if ("color".equals(qName)) {
            System.out.println("color: " + sb);
            String color = sb.toString();
            car.setColor(color);
        }
        if ("year".equals(qName)) {
            System.out.println("year: " + sb);
            String year = sb.toString();
            car.setYear(year);
        }
        if ("price".equals(qName)) {
            System.out.println("price: " + sb);
            String price = sb.toString();
            car.setPrice(price);
            System.out.println("===================");
        }
    }

    @Override
    public void endDocument() throws SAXException {

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
        int carsSize = cars.size();
        System.out.println(carsSize);
        System.out.println(cars.toString());
    }
}
