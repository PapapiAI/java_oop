# Bài 1: Xây dựng và sử dụng các contructors của lớp Phân Số

> **Đề bài:**
> Tạo lớp **PhanSo** có các constructor và phương thức xử lý để đáp ứng đoạn mã chạy thử bên dưới.
>
>   * **Thuộc tính:** `tuSo`, `mauSo`
>   * **Yêu cầu Constructors:**
>       * Mặc định: `0/1`
>       * 1 tham số (chỉ tử số): `tuSo/1`
>       * 2 tham số: `tuSo/mauSo`
>   * **Các phương thức:**
>       * `xuat()`: In phân số ra màn hình.
>       * `copy()`: Trả về bản sao của đối tượng hiện tại.
>       * `cong(int value)`: Cộng số nguyên vào tử số.

**Đoạn mã chạy thử (Test case):**

```java
public static void main(String[] args) {
    PhanSo a = new PhanSo();
    a.xuat();                       // 0

    PhanSo b = new PhanSo(1, 2);
    b.xuat();                       // 1/2

    PhanSo c = new PhanSo(3);
    c.xuat();                       // 3

    PhanSo d = new PhanSo(-6, -2);
    d.xuat();                       // 3

    PhanSo e = new PhanSo(3, -1);
    e.xuat();                       // -3

    PhanSo f = e.copy();
    f.cong(100);
    e.xuat();                       // -3
    f.xuat();                       // 97
}
```

-----

# Bài 2: Xây dựng và sử dụng các contructors của lớp Thời Gian

> **Đề bài:**
> Tạo lớp **ThoiGian** với các thuộc tính `gio`, `phut`, `giay` và các constructor để xử lý khởi tạo giờ.
>
>   * **Yêu cầu Constructors:**
>       * Mặc định: `00:00:00`
>       * 1 tham số: `gio` (phút, giây mặc định 0)
>       * 2 tham số: `gio`, `phut` (giây mặc định 0)
>       * 3 tham số: `gio`, `phut`, `giay`
>       * Constructor sao chép: Khởi tạo từ một đối tượng `ThoiGian` khác.
>   * **Phương thức:**
>       * `xuat()`: Xuất thời gian theo định dạng `HH:MM:SS` (VD: 07:05:01)

**Đoạn mã chạy thử (Test case):**

```java
public static void main(String[] args) {
    ThoiGian a = new ThoiGian();
    a.xuat();                       // 00:00:00

    ThoiGian b = new ThoiGian(7);
    b.xuat();                       // 07:00:00

    ThoiGian c = new ThoiGian(7, 30);
    c.xuat();                       // 07:30:00

    ThoiGian d = new ThoiGian(7, 30, 50);
    d.xuat();                       // 07:30:50

    ThoiGian f = new ThoiGian(d);
    f.xuat();                       // 07:30:50
}
```

-----

# Bài 3: Xây dựng lớp Student với tính bao đóng

> **Đề bài:**
> Xây dựng lớp **Student** quản lý thông tin học sinh thỏa mãn tính bao đóng (Encapsulation).
>
>   * **Thuộc tính (private):**
>       * `id`: Mã học sinh
>       * `name`: Tên học sinh
>       * `score`: Điểm số
>   * **Yêu cầu nghiệp vụ (Business Logic):**
>       * **id:** Chỉ được xem (Getter), không được phép chỉnh sửa sau khi khởi tạo (Không có Setter).
>       * **name:** Bắt buộc nhập. Setter phải kiểm tra nếu rỗng thì báo lỗi.
>       * **score:** Phải nằm trong khoảng `0 - 10`. Setter phải kiểm tra điều kiện, nếu sai báo lỗi và không cập nhật.

**Hướng dẫn thực hiện:**

1.  **Khởi tạo:**
      * Khai báo 3 thuộc tính `private`.
      * Tạo Constructor để khởi tạo giá trị ban đầu.
2.  **Getter/Setter:**
      * `getId()`: Chỉ có getter.
      * `setName(String name)`: Kiểm tra `name` có rỗng không trước khi gán.
      * `setScore(double score)`: Kiểm tra `score >= 0 && score <= 10`.
3.  **Kiểm thử:**
      * Tạo đối tượng Student và cố tình gán dữ liệu sai (điểm âm, tên rỗng) để kiểm tra logic validation.