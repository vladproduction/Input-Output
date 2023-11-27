package vladproduction.com.SAX.students;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main_students {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File file = new File("src/main/java/vladproduction/com/SAX/students/students.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler studentsHandler = new MyHandler();
        parser.parse(file, studentsHandler);
    }
}
