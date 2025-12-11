package ss2_constructor.encapsulation;

public class StudentManager {
    public static void main(String[] args) {
        Student student = new Student();

/// Không cho phép gán giá trị cho thuộc tính name từ bên ngoài
//        student.name = "Nguyễn Văn A";

/// Muốn gán giá trị -> sử dụng setter
/// Muốn lấy giá trị -> sử dụng getter
//        student.setName("Nguyễn Văn A");
//        System.out.println("Name: " + student.getName());

/// Bảo vệ dữ liệu -> kiểm tra trước dữ liệu đầu vào
//        student.setScore(50);
//        System.out.println("Điểm: " + student.getScore());

/// ID không được set từ bên ngoài -> nó là dữ liệu không đổi, định danh duy nhất
/// -> không cung cấp setter setId(), chỉ có getter getId()
//        student.setId(123);
    }
}
