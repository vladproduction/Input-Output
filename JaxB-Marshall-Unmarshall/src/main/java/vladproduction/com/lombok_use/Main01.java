package vladproduction.com.lombok_use;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

public class Main01 {

    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        studentList.setStudents(new ArrayList());

        Student student1 = new Student(1, "Letos", "letos@gmail.st");
        Student student2 = new Student(2, "Viktor", "viktor@gmail.st");
        Student student3 = new Student(3, "Mella", "mella@gmail.st");
        //add students to Array has been created as anonim
        studentList.getStudents().add(student1);
        studentList.getStudents().add(student2);
        studentList.getStudents().add(student3);


        Student student = new Student(1, "Mark", "mark@gmail.st");
        convertXml(student);
        saveToXml(student);

        Student studentN = loadFromXml();
        System.out.println(studentN);

        saveListToXml(studentList);

        StudentList list = loadListFromXml();
        System.out.println(list);
    }


    //convert object to xml and show in console
    private static void convertXml(Student student) {  //what we are going to convert
        System.out.println("saveXml()");
        JAXBContext context = null; // from which class
        try {
            context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();  //it`s instrument for conversion
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //just to be readable
            StringWriter stringWriter = new StringWriter(); //construct the string
            marshaller.marshal(student, stringWriter); //(object for convert, how it`s look like & where to put)
            String xmlContent = stringWriter.toString(); // we can see our student as String
            System.out.println(xmlContent); //print to console
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    //save object to xml File
    private static void saveToXml(Student student) {
        System.out.println("saveToXml()");
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);         //from which class
            Marshaller marshaller = context.createMarshaller();        //it`s instrument for conversion
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //just to be readable
            marshaller.marshal(student,
                    new File("src/main/java/vladproduction/com/lombok_use/students.xml"));
            //(object for save, where to put)
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    //load object from xml File to console
    private static Student loadFromXml() {
        System.out.println("loadFromXml()");
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);         //from which class
            Unmarshaller unmarshaller = context.createUnmarshaller();        //it`s instrument for conversion
            Student student = (Student) unmarshaller.unmarshal(
                    new File("src/main/java/vladproduction/com/lombok_use/students.xml"));
            //(object for save, where to put)
            return student;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    //save List to xml File
    private static void saveListToXml(StudentList students) {
        System.out.println("saveListToXml()");
        try {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(students,
                    new File("src/main/java/vladproduction/com/lombok_use/students.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    //load List from xml File to console
    private static StudentList loadListFromXml() {
        System.out.println("loadListFromXml()");
        try {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StudentList students = (StudentList) unmarshaller.unmarshal(
                    new File("src/main/java/vladproduction/com/lombok_use/students.xml"));
            return students;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
