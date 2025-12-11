package ss1_oop_overview;

import java.util.ArrayList;

public class StudentManager {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        s1.name = "Nguyễn Văn A";
//        s1.age = 20;
//        s1.hobby = "Bóng đá";
//
//        System.out.println("Thông tin sinh viên 1");
//        System.out.println("name: " + s1.name);
//        System.out.println("age: " + s1.age);
//        System.out.println("hobby: " + s1.hobby);


//        Student s2 = new Student();
//        s2.name = "Nguyễn Văn B";
//        s2.age = 21;
//        s2.hobby = "Cầu lông";
//
//        System.out.println("Thông tin sinh viên 2");
//        System.out.println("name: " + s2.name);
//        System.out.println("age: " + s2.age);
//        System.out.println("hobby: " + s2.hobby);


//        Student s1 = new Student();
//        System.out.println("Nhập thông tin sinh viên 1");
//        s1.input();
//        System.out.println("Thông tin sinh viên 1");
//        s1.output();
//
//        Student s2 = new Student();
//        System.out.println("Nhập thông tin sinh viên 2");
//        s2.input();
//        System.out.println("Thông tin sinh viên 2");
//        s2.output();


        ArrayList<Student> students = new ArrayList<>();

        int n = 2;

        Student student;

        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập vào thông tin sinh viên thứ %d: \n", i + 1);
            student = new Student();
            student.input();
            students.add(student);
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("Thông tin của sinh viên thứ %d: \n", i + 1);
            students.get(i).output();
        }
    }
}
