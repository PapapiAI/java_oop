# Ứng dụng quản lý điện thoại - Bổ sung thêm chức năng

## Đề bài

Bổ sung thêm chức năng bên dưới cho bài `ứng dụng quản lý điện thoại`

#### `5. Sắp xếp theo giá`
#### `6. Tìm kiếm`

## Hướng dẫn cơ bản

### 5. Sắp xếp theo giá

**Mô tả**

* Đầu tiên, cần chuyển từ hai ArrayList (cho điện thoại cũ và mới) sang một ArrayList duy nhất chứa cả hai loại.
* Tạo một ArrayList mới có kiểu dữ liệu là Điện Thoại. Nhớ rằng, bạn có thể lưu cả Điện thoại cũ và Điện thoại mới trong danh sách này nhờ khả năng đa hình.
* Điều chỉnh chương trình để chấp nhận ArrayList mới này. Sử dụng từ khóa `instanceof` để xác định loại điện thoại khi cần.
* Sắp xếp ArrayList dựa trên giá. Dùng thuật toán sắp xếp đổi chỗ trực tiếp (Interchange Sort).

### 6. Tìm kiếm

**Mô tả**

* **Tìm kiếm theo loại:** Dùng từ khóa `instanceof` để lọc ra các điện thoại cũ hoặc mới.
* **Tìm kiếm theo giá:** Cho phép người dùng nhập khoảng giá. duyệt qua ArrayList và lọc ra các điện thoại nằm trong khoảng giá này.
* **Tìm kiếm theo tên:** Nhận đầu vào từ người dùng, duyệt qua ArrayList và sử dụng phương thức `contains` trên tên của mỗi điện thoại để tìm kiếm gần đúng.
