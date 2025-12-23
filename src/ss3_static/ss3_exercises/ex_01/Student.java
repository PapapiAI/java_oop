package ss3_static.ss3_exercises.ex_01;

public class Student {
    private int id;
    private String name;
    private double score;
    private static int studentCount = 0; // Biến tĩnh để đếm số lượng sinh viên

    // Constructor
    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        studentCount++; // Tăng giá trị studentCount mỗi khi tạo một đối tượng sinh viên mới
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // Phương thức tĩnh để truy xuất số lượng sinh viên
    public static int getStudentCount() {
        return studentCount;
    }
}
