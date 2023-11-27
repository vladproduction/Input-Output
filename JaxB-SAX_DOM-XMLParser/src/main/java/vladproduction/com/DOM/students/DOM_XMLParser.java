package vladproduction.com.DOM.students;

import org.w3c.dom.*;
import vladproduction.com.SAX.students.Student;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DOM_XMLParser {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document document = builder.parse(
                    new File("src/main/java/vladproduction/com/DOM/students/students.xml"));
            
            // Get the root element
            Element root = document.getDocumentElement();
            
            // Get all student elements
            NodeList studentList = root.getElementsByTagName("student");
            List<Student> result = new ArrayList<>(); //create list of Students(example)
            // Loop through each student element
            for (int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                Student student1 = new Student(); //new Student, we add it to list
                
                // Get the student id and active status attributes
                String id = student.getAttribute("id");
                String active = student.getAttribute("active");
                
                // Get the first name, last name, and location
                String firstName = student.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = student.getElementsByTagName("lastName").item(0).getTextContent();
                String location = student.getElementsByTagName("location").item(0).getTextContent();

                student1.setFirstName(firstName); //setting textContent for our Object(student) firstName
                result.add(student1); //add to list
                // Print the student details
                System.out.println("Student ID: " + id);
                System.out.println("Active: " + active);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Location: " + location);
                System.out.println();
            }
            for (Student student: result) { //looping our list
                System.out.println("=== student ===");
                System.out.println(student);//printing each student from our xml
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
