package vladproduction.com.student_list;

public class Main_Student {
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(101);
        student.setName("Student_101");
        student.setEmail("Student_101@email.com");
        student.setAveragePoint(11.5);

        ProcessClass pc = new ProcessClass();
        pc.save(student);
        Student loadStudent = pc.load();
        System.out.println(loadStudent);

    }
}
