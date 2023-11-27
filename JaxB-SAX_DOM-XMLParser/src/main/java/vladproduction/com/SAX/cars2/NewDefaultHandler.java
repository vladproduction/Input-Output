package vladproduction.com.SAX.cars2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class NewDefaultHandler extends DefaultHandler {

    private List<Auto> autoList;

    private Auto auto;

    private StringBuilder sb = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start--->");
        autoList = new ArrayList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.setLength(0);
        if("priceList".equals(qName)){
            String year = attributes.getValue("Year");
            String city = attributes.getValue("City");
            String country = attributes.getValue("Country");
            sb.append("Year: "+year);
            sb.append("; City: "+city);
            sb.append("; Country: "+country);
            System.out.println("[priceList] "+sb);
        }
        if("deliveryCentre".equals(qName)){
            String department = attributes.getValue("department");
            sb.append("[department]: ("+department+")");
            System.out.println(sb);
            System.out.println("==============================");
        }
        if("auto".equals(qName)){
            auto = new Auto();
            String number = attributes.getValue("number");
            String delivered = attributes.getValue("delivered");
            sb.append("number: "+number);
            sb.append("; delivered: "+delivered);
            System.out.println("<auto> "+sb);
        }
        if("price".equals(qName)){
            String currency = attributes.getValue("currency");
            sb.append("("+currency+") ");

        }
        if ("priceUAH".equals(qName)){
            String currencyUAH = attributes.getValue("currencyNative");
            String rate = attributes.getValue("rate");
            String rateDate = attributes.getValue("rateDate");
            sb.append("("+currencyUAH+")"+"/"+rate+"/"+" ("+rateDate+") "+" = ");

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       sb.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if("auto".equals(qName)){
            autoList.add(auto);
        }
        if("name".equals(qName)){
            System.out.println("name: "+sb);
            String name = sb.toString();
            auto.setName(name);
        }
        if("model".equals(qName)){
            System.out.println("model: "+sb);
            String model = sb.toString();
            auto.setModel(model);
        }
        if("equipment".equals(qName)){
            System.out.println("equipment: "+sb);
            String equipment = sb.toString();
            auto.setEquipment(equipment);
        }
        if("color".equals(qName)){
            System.out.println("color: "+sb);
            String color = sb.toString();
            auto.setColor(color);
        }
        if("price".equals(qName)){
            System.out.println("price: "+sb+" euro");
            String price = sb.toString();
            auto.setPrice(price);
        }
        if("priceUAH".equals(qName)){
            System.out.println("priceUAH: "+sb+" uah");
            String priceUAH = sb.toString();
            auto.setPriceUAH(priceUAH);
            System.out.println("===================");
        }

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End--->");

        for (int i = 0; i < autoList.size(); i++) {
            System.out.println(autoList.get(i));
        }
        int size = autoList.size();
        System.out.println("size = " + size);
        System.out.println(autoList.toString());
    }
}
