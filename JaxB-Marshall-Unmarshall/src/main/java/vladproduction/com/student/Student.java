package vladproduction.com.student;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double academicPerformance;

    public Student(int id, String firstName, String lastName, double academicPerformance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicPerformance = academicPerformance;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAcademicPerformance() {
        return academicPerformance;
    }

    @XmlElement
    public void setAcademicPerformance(double academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return id == student.id && Double.compare(academicPerformance, student.academicPerformance) == 0 && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, academicPerformance);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", academicPerformance=" + academicPerformance +
                '}';
    }
}
