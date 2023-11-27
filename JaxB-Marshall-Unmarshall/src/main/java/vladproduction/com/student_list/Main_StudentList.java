package vladproduction.com.student_list;

import java.util.ArrayList;
import java.util.List;

public class Main_StudentList {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setId(101);
        student1.setName("Student_101");
        student1.setEmail("Student_101@email.com");
        student1.setAveragePoint(11.5);

        Student student2 = new Student();
        student2.setId(102);
        student2.setName("Student_102");
        student2.setEmail("Student_102@email.com");
        student2.setAveragePoint(10.9);

        Student student3 = new Student();
        student3.setId(103);
        student3.setName("Student_103");
        student3.setEmail("Student_103@email.com");
        student3.setAveragePoint(11.8);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        StudentList student_list = new StudentList();
        student_list.setStudentList(studentList);

        ProcessClass pc = new ProcessClass();
        pc.saveList(student_list);
        StudentList loadStudentList = pc.loadList();
        System.out.println(loadStudentList);

    }
}
