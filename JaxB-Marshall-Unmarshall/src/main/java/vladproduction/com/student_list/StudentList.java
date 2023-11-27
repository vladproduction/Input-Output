package vladproduction.com.student_list;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class StudentList {

    private List<Student> studentList;


    public List<Student> getStudentList() {
        return studentList;
    }

    @XmlElement
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "studentList=" + studentList +
                '}';
    }
}
