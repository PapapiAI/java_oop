package ss3_static;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Nguyễn Văn A");
        Student s2 = new Student("Nguyễn Văn B");
        Student s3 = new Student("Nguyễn Văn B");

        System.out.println(s3.getId());

/// Thay đổi giá trị biến static
//        Student.schoolName = "Kinh Tế";

/// Truy xuất thành phần static (thuộc tính, phương thức) thông qua tên class
/// Không cần khởi tạo đối tượng nhưng vẫn có thể truy xuất các thành phần static
//        System.out.println(Student.schoolName);

/// Cũng có thể truy xuất thành phần static thông qua đối tượng
/// Nhưng nên sử dụng tên class để truy xuất thành phần static
//        System.out.println(s1.schoolName);
//        System.out.println(s2.schoolName);

/// Muốn gọi method non-static -> cần phải khởi tạo đối tượng
//        System.out.println("ID: " + Student.getId());
//        System.out.println("ID: " + s1.getId());

/// Class tiện ích của Java
/// Cực kỳ tiện lợi, không cần ra đối tượng gì cả
/// -> chỉ cần lấy tên Class. là sử dụng được luôn
//        System.out.println("Số Pi: " + Math.PI);
//        System.out.println("Căn bậc hai: " + Math.sqrt(9));

/// Class tiện ích tự tạo
//        LocalDate localDate = LocalDate.now();
//        String strLocalDate = LocalDateTimeUtil.format(localDate);
//        System.out.println(strLocalDate);

/// Không thể khởi tạo đối tượng từ class Math
/// Vì nó đã được Java khai báo là private constructor
/// Việc tạo đối tượng như vậy gây tốn bộ nhớ vô ích
//        Math m = new Math();
    }
}
