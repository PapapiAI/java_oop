package ss2_constructor.exercises.ex_03;

public class Student {
    private int id;
    private String name;
    private double score;

    // Constructor
    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter cho name
    public void setName(String name) {
        // Kiểm tra xem name chỉ chứa khoảng trắng
        if (name.trim().equals("")) {
            System.out.println("Lỗi: Tên bắt buộc nhập.");
        } else {
            this.name = name;
        }
    }

    // Getter cho score
    public double getScore() {
        return score;
    }

    // Setter cho score
    public void setScore(double score) {
        // Kiểm tra xem điểm số nằm trong khoảng từ 0 đến 10
        if (score >= 0 && score <= 10) {
            this.score = score;
        } else {
            System.out.println("Lỗi: Điểm số phải nằm trong khoảng từ 0 đến 10.");
        }
    }
}
