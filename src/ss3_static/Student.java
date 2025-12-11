package ss3_static;

public class Student {
    private final int id;
    private String name;

    static int count = 0;
    /// Biến static sử dụng chung cho mọi đối tượng
    static String schoolName = "Bách Khoa";

    /// Method non-static thuộc về đối tượng
    /// -> muốn sử dụng method non-static -> cần phải khởi tạo đối tượng
    public int getId() {
        return id;
    }

    /// Constructor 2 tham số
    public Student(String name) {
        count++;
        this.id = count;
        this.name = name;
    }
}
