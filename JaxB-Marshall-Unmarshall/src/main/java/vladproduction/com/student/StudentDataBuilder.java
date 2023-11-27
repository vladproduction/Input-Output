package vladproduction.com.student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class StudentDataBuilder {

    private final File studentFile = new File("src/main/java/vladproduction/com/student/studentFile.xml");

    public void save(Student student) throws JAXBException {
        try{
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller m = context.createMarshaller();
            m.marshal(student,studentFile);

        }catch (JAXBException e){
            throw new RuntimeException(e);
        }

    }

    public Student load(){
        try{
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller unMarsh = context.createUnmarshaller();
            return (Student)unMarsh.unmarshal(studentFile);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }

}
