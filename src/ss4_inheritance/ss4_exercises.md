# Bài tập - Kế thừa - Ứng dụng quản lý điện thoại

## Đề bài

**I. Mô tả chương trình**

Chương trình quản lý điện thoại của một cửa hàng bán điện thoại di động.
Điện thoại được chia làm 2 loại:

* Điện thoại mới
* Điện thoại cũ

Các loại điện thoại này sẽ bao gồm các thông tin: **id, Tên điện thoại, Giá bán, Thời gian bảo hành, Hãng sản xuất** (ví dụ: iPhone, Samsung, ...)

**Quy tắc ID:**
Đối với **id** của mỗi điện thoại sẽ tự động tăng theo quy tắc sau:

* Đối với **điện thoại mới**: id sẽ có dạng `"DTMXXX"`, trong đó "X" là một số từ 0 đến 9.
* Đối với **điện thoại cũ**: id sẽ có dạng `"DTCXXX"`, trong đó "X" là một số từ 0 đến 9.

**Thông tin riêng:**

* Đối với **điện thoại cũ** có thêm thông tin:
* Tình trạng pin (Còn bao nhiêu phần trăm)
* Mô tả thêm


* Đối với **điện thoại mới** có thêm thông tin:
* Số lượng



## Hướng dẫn các bước thực hiện

**II. Yêu cầu chương trình**

### Task 1: Tạo menu

*(Chỉ yêu cầu tạo menu chương trình sử dụng các vòng lặp, không yêu cầu viết code các chức năng)*

-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI --

1. Xem danh sách điện thoại
2. Thêm mới
3. Cập nhật
4. Xóa
5. Sắp xếp theo giá
6. Tìm kiếm
7. Tính tổng tiền
8. Giảm giá cho điện thoại cũ
9. Thoát

**Chi tiết các menu con:**

* Khi chọn chức năng số **1. Xem danh sách điện thoại** thì chương trình hiển thị thanh menu con bao gồm:
1. Xem tất cả
2. Xem điện thoại cũ
3. Xem điện thoại mới
4. Trở về menu chính


* Khi chọn chức năng số **2. Thêm mới** thì chương trình hiển thị thanh menu con bao gồm:
1. Thêm mới điện thoại cũ
2. Thêm mới điện thoại mới
3. Trở về menu chính


* Khi chọn chức năng số **5. Sắp xếp theo giá** thì chương trình hiển thị thanh menu con bao gồm:
1. Tăng dần
2. Giảm dần
3. Trở về menu chính


* Khi chọn chức năng số **6. Tìm kiếm** thì chương trình hiển thị thanh menu con bao gồm:
1. Tìm kiếm tất cả điện thoại
2. Tìm kiếm điện thoại cũ
3. Tìm kiếm điện thoại mới
4. Trở về menu chính


* Khi lựa chọn vào **1, 2, 3** thì xuất hiện menu:
1. Tìm kiếm theo giá (Nhập khoảng từ bao nhiêu đến bao nhiêu)
2. Tìm kiếm theo tên
3. Tìm kiếm theo hãng
4. Trở về menu Tìm kiếm




* Khi chọn chức năng số **9. Thoát** thì kết thúc chương trình.

### Task 2: Tạo các class, property, method theo OOP

Task này chỉ yêu cầu tạo các class, method, property theo OOP, không yêu cầu viết code các chức năng của chương trình.

### Task 3: Xây dựng hoàn chỉnh các chức năng sau

**Hướng dẫn cơ bản cho task 3**

**1. Xem danh sách điện thoại**

* **Mô tả:**
* **Khởi tạo:** Tạo ra 2 ArrayList chứa thông tin tương ứng của điện thoại cũ và điện thoại mới. Tạo khối static để đưa dữ liệu ban đầu vào cho 2 ArrayList này.


* **Chức năng:**
* **Xem tất cả:** Sử dụng 2 vòng lặp để xuất thông tin của điện thoại cũ và điện thoại mới.
* **Xem điện thoại cũ:** Sử dụng vòng lặp để xuất thông tin của điện thoại cũ.
* **Xem điện thoại mới:** Sử dụng vòng lặp để xuất thông tin của điện thoại mới.



**2. Thêm mới**

* **Mô tả:**
* **Chọn chức năng thêm mới:**
1. **Thêm mới điện thoại cũ:** Gọi đến phương thức input của điện thoại cũ, xử lý id tự động tăng theo format quy định.
2. **Thêm mới điện thoại mới:** Gọi đến phương thức input của điện thoại mới, xử lý id tự động tăng theo format quy định.





**3. Cập nhật**

* **Mô tả:**
* **Nhập id:** Người dùng nhập vào id, kiểm tra format id (6 ký tự, bắt đầu bằng DTC hoặc DTM).
* **Nếu sai format:** Báo lỗi.
* **Duyệt trong ArrayList tương ứng:** Duyệt thông tin trong ArrayList điện thoại cũ hoặc mới.
* **Nếu không tìm thấy:** Báo id không tồn tại.
* **Nếu tìm thấy:** Gọi đến phương thức input của điện thoại tương ứng để cập nhật thông tin, sau đó báo cập nhật thành công.



**4. Xóa**

* **Mô tả:**
* **Nhập id:** Người dùng nhập vào id, kiểm tra format id (6 ký tự, bắt đầu bằng DTC hoặc DTM).
* **Nếu sai format:** Báo lỗi.
* **Duyệt trong ArrayList tương ứng:** Duyệt thông tin trong ArrayList điện thoại cũ hoặc mới.
* **Nếu không tìm thấy:** Báo id không tồn tại.
* **Nếu tìm thấy:** Thực hiện xóa đối tượng khỏi danh sách và thông báo xóa thành công.