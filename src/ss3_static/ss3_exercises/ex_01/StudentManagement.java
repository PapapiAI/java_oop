package ss3_static.ss3_exercises.ex_01;

public class StudentManagement {
    public static void main(String[] args) {

        // Tạo các đối tượng sinh viên
        Student student1 = new Student(1, "Alice", 85.5);
        Student student2 = new Student(2, "Bob", 92.0);
        Student student3 = new Student(3, "Charlie", 78.7);

        // In ra số lượng sinh viên đã được tạo
        System.out.println("Số lượng sinh viên: " + Student.getStudentCount()); // Kết quả: 3
    }
}