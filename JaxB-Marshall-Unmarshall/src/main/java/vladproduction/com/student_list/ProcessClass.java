package vladproduction.com.student_list;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ProcessClass {

    private final File file = new File("src/main/java/vladproduction/com/student_list/student.xml");
    private final File fileList = new File("src/main/java/vladproduction/com/student_list/students.xml");

    public void save(Student student){
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(student,file);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }

    public Student load(){
        try{
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller unM = context.createUnmarshaller();
            return (Student)unM.unmarshal(file);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }

    //methods for list:

    public void saveList(StudentList students){
        try {
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.marshal(students,fileList);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }

    public StudentList loadList(){
        try{
            JAXBContext context = JAXBContext.newInstance(StudentList.class);
            Unmarshaller unM = context.createUnmarshaller();
            return (StudentList)unM.unmarshal(fileList);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }
}
