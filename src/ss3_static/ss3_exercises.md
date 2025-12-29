# Bài 1: Đếm số lượng đối tượng Student được tạo ra

## Đề bài

> Viết một lớp `Student` đại diện cho sinh viên, bao gồm các thông tin sau:
> * Mã số sinh viên
> * Tên
> * Điểm
> 
> 
> Sử dụng biến tĩnh (`static`) để đếm số lượng sinh viên đã được tạo ra và viết phương thức tĩnh để truy xuất số lượng sinh viên.

## Mục tiêu

* Hiểu rõ về biến tĩnh và phương thức tĩnh trong Java.
* Biết cách sử dụng biến tĩnh để lưu trữ thông tin chung cho tất cả các đối tượng của lớp.
* Biết cách sử dụng phương thức tĩnh để truy cập thông tin tĩnh.

## Hướng dẫn các bước thực hiện

### Xây dựng lớp Student

* Khai báo các trường **id**, **name**, **score** để lưu trữ thông tin cá nhân của sinh viên.
* Khai báo biến tĩnh **studentCount** để theo dõi số lượng sinh viên đã được tạo.

### Tạo Constructor

* Trong constructor, khởi tạo thông tin sinh viên và tăng giá trị của **studentCount** lên 1 mỗi khi một đối tượng mới được tạo.

### Thực hiện các phương thức Getter và Setter

* Viết các phương thức getter và setter cho các trường **id**, **name**, **score**.

### Viết phương thức tĩnh truy xuất số lượng sinh viên

* Tạo một phương thức tĩnh (`static method`) để trả về giá trị của biến tĩnh **studentCount**. Phương thức này cho phép truy cập số lượng sinh viên mà không cần đối tượng cụ thể.

### Test lớp Student

* Tạo nhiều đối tượng `Student` và in ra số lượng sinh viên bằng phương thức tĩnh đã tạo.

## Lưu ý

* **Biến tĩnh** là một biến được chia sẻ giữa tất cả các đối tượng của một lớp, nên nó có thể được truy cập và thay đổi qua tất cả các đối tượng.
* **Phương thức tĩnh** có thể được gọi mà không cần đối tượng cụ thể của lớp, điều này hữu ích cho việc truy xuất thông tin chung như số lượng sinh viên trong trường hợp này.

---

# Bài 2: Xây dựng lớp tiện ích MathUtil

## Đề bài

> Viết một lớp `MathUtil` chứa các phương thức tĩnh (`static`) để thực hiện các chức năng sau:
> * Cộng 2 số.
> * Trừ 2 số.
> * Nhân 2 số.
> * Chia 2 số.
> 
> 

## Mục tiêu

* Hiểu cách sử dụng phương thức tĩnh trong Java.
* Nắm vững cách thiết kế và sử dụng các phương thức tiện ích.

## Hướng dẫn các bước thực hiện

### Xây dựng lớp MathUtil

 Khởi tạo lớp `MathUtil` và thêm các phương thức tĩnh sau:
* **`add(double a, double b)`**: Cộng hai số và trả về kết quả.
* **`subtract(double a, double b)`**: Trừ hai số và trả về kết quả.
* **`multiply(double a, double b)`**: Nhân hai số và trả về kết quả.
* **`divide(double a, double b)`**: Chia hai số và trả về kết quả.



### Test lớp MathUtil

* Trong hàm main của một class khác, gọi các phương thức tĩnh từ lớp `MathUtil` và kiểm tra kết quả.

## * Lưu ý

* Các phương thức tĩnh nên được thiết kế để có thể tái sử dụng trong các chương trình khác nhau, nên cố gắng viết chúng một cách tổng quát nhất có thể.

---

# Bài 3. Xây dựng lớp tiện ích LocalDateUtil

## Đề bài

> Tạo một lớp `LocalDateUtil` gồm các phương thức tĩnh (`static`) để thực hiện các chức năng sau:
> * Chuyển đổi chuỗi với định dạng `dd/MM/yyyy` sang `LocalDate`.
> * Chuyển đổi chuỗi với định dạng `yyyy/MM/dd` sang `LocalDate`.
> * Chuyển đổi `LocalDate` với định dạng sang chuỗi với định dạng `dd/MM/yyyy`.
> * Chuyển đổi `LocalDate` với định dạng sang chuỗi với định dạng `yyyy/MM/dd`.
> 
> 

## Mục tiêu

* Hiểu cách sử dụng `DateTimeFormatter` để chuyển đổi giữa chuỗi và `LocalDate`.
* Thực hiện được việc chuyển đổi định dạng ngày tháng sử dụng Java 8.

## Hướng dẫn các bước thực hiện

### Xây dựng lớp LocalDateUtil

Khởi tạo lớp `LocalDateUtil` và thêm các phương thức tĩnh sau:
* **`fromString_ddMMyyyy(String date)`**: Chuyển đổi chuỗi với định dạng `dd/MM/yyyy` sang `LocalDate`.
* **`fromString_yyyyMMdd(String date)`**: Chuyển đổi chuỗi với định dạng `yyyy/MM/dd` sang `LocalDate`.
* **`toString_ddMMyyyy(LocalDate date)`**: Chuyển đổi `LocalDate` sang chuỗi với định dạng `dd/MM/yyyy`.
* **`toString_yyyyMMdd(LocalDate date)`**: Chuyển đổi `LocalDate` sang chuỗi với định dạng `yyyy/MM/dd`.


* Sử dụng lớp `DateTimeFormatter` để định dạng và phân tích chuỗi ngày.

### Test lớp LocalDateUtil

* Trong hàm `main` của một class khác, gọi các phương thức tĩnh từ lớp `LocalDateUtil` và kiểm tra kết quả.

## Lưu ý

* Đảm bảo rằng định dạng đầu vào đúng với định dạng được đề ra trong các phương thức chuyển đổi.
* Các phương thức tĩnh nên được thiết kế để có thể tái sử dụng trong các chương trình khác nhau, nên cố gắng viết chúng một cách tổng quát nhất có thể.
