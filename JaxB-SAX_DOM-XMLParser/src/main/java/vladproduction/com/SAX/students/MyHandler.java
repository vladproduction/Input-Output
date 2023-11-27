package vladproduction.com.SAX.students;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import vladproduction.com.SAX.autosalon.Car;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    private List<Student> students;

    private Student student;

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("=== start document ===");
        students = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.setLength(0);
        if("students".equals(qName)){
            sb.append("----------------------\n");
            sb.append("students:\n");
            sb.append("----------------------");
            System.out.println(sb);
        }
        if("student".equals(qName)){
            student = new Student();
            String id = attributes.getValue("id");
            String active = attributes.getValue("active");
            sb.append("id: ").append(id).append("\n");
            sb.append("active: ").append(active);
            System.out.println(sb);

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("student".equals(qName)){
            students.add(student);
        }
        if("firstName".equals(qName)){
            System.out.println("First name: " + sb);
            String firstName = sb.toString();
            student.setFirstName(firstName);
        }
        if("lastName".equals(qName)){
            System.out.println("Last name: " + sb);
            String lastName = sb.toString();
            student.setFirstName(lastName);
        }
        if("location".equals(qName)){
            System.out.println("Location: " + sb);
            String location = sb.toString();
            student.setFirstName(location);
            System.out.println("===================");
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("=== finish document ===");
        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }
}
