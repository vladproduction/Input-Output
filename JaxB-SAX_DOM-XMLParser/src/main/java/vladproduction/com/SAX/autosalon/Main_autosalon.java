package vladproduction.com.SAX.autosalon;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main_autosalon {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Create path to file
        File file = new File("src/main/java/vladproduction/com/SAX/autosalon/autosalon.xml");
        // Create a SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(file,new MyHandler());
    }
}
