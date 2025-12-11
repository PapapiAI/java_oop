package ss2_constructor.student_manager;

import java.util.Scanner;

public class Student {
    String name;
    int age;
    String hobby;

    public Student() {
        age = 18;
    }

//    public Student(String hobby) {
////        System.out.println("Call constructor");
//        hobby = hobby;
//    }

//    public Student(int age, String hobby) {
//        this.age = 18;
//        this.hobby = "bóng đá";
//    };
//
//    public Student(String name, int age, String hobby) {
//        this(age, hobby);
//        this.hobby = hobby;
//    }

//    @Override
//    public String toString() {
//        return "Student{name='" + name + "', age=" + age + ", hobby='" + hobby + "'}";
//    }



    public void run() {
        System.out.println(name + " chạy bộ");
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào tên: ");
        name = sc.nextLine();

        System.out.println("Nhập vào tuổi: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập vào sở thích: ");
        hobby = sc.nextLine();
    }

    public void output() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("hobby: " + hobby);
    }
}
