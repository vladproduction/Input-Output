package vladproduction.com.student;

import javax.xml.bind.JAXBException;

public class MainStudent {
    public static void main(String[] args) throws JAXBException {
        StudentDataBuilder sdb = new StudentDataBuilder();
        sdb.save(new Student(1,"John","Doe",10.5));
        Student studentFromFile = sdb.load();
        System.out.println(studentFromFile);
    }
}
