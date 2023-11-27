package vladproduction.com.SAX.phoneNumberAnonymous;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import vladproduction.com.SAX.phoneNumber.PhoneNumber;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_anonymous {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File file = new File("src/main/java/vladproduction/com/SAX/phoneNumberAnonymous/phoneNumber2.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file, new DefaultHandler() {

            private List<PhoneNumber> contactList;
            private PhoneNumber contact;
            private StringBuilder sb = new StringBuilder();


            @Override
            public void startDocument() throws SAXException {
                System.out.println("startDocument()");
                contactList = new ArrayList();
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                sb.setLength(0);
                if ("contactList".equals(qName)) {
                    System.out.println("contactList: ");
                }
                if ("phoneNumber".equals(qName)) {
                    contact = new PhoneNumber();
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String text = new String(ch, start, length);
                if (!text.trim().isEmpty()) {
                    sb.append(text);
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if ("phoneNumber".equals(qName)) {
                    contactList.add(contact);
                }
                if ("name".equals(qName)) {
                    String name = sb.toString();
                    contact.setName(name);
                    System.out.println("name: " + sb);
                }
                if ("number".equals(qName)) {
                    String number = sb.toString();
                    contact.setNumber(number);
                    System.out.println("number: " + sb);
                }
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("endDocument()");
                for (int i = 0; i < contactList.size(); i++) {
                    System.out.println(contactList.get(i));
                }
            }
        });
    }
}
