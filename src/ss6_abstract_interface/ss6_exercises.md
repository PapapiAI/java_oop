# Ứng dụng quản lý điện thoại - Bổ sung thêm chức năng

## Đề bài

Bổ sung thêm chức năng bên dưới cho bài `ứng dụng quản lý điện thoại`

#### `7. Tính tổng tiền`

#### `8. Giảm giá điện thoại cũ`

## Hướng dẫn cơ bản

### 7. Tính tổng giá

**Mô tả**

Tính tổng giá của tất cả các điện thoại có trong cửa hàng.

**Gợi ý**

- Trong lớp **DienThoai**, thêm một phương thức trừu tượng (abstract) để tính tổng giá. Việc này cần thiết vì mỗi loại điện thoại có cách tính tổng giá riêng biệt, không thể thực hiện tại lớp cha **DienThoai**.
- Trong lớp **DienThoaiCu**, triển khai phương thức tính tổng giá theo cách riêng của điện thoại cũ và trả về giá của điện thoại.
- Trong lớp **DienThoaiMoi**, triển khai phương thức tính tổng giá theo cách riêng của điện thoại mới và trả về giá của điện thoại = số lượng \* giá.
- Sử dụng vòng lặp để duyệt qua danh sách tất cả các điện thoại và tính tổng giá.

### 8. Giảm giá cho điện thoại cũ

**Mô tả**

Thêm chức năng giảm giá cho các điện thoại cũ để khuyến khích mua sắm.

**Gợi ý**

- Tạo một interface mang tên **KhuyenMai** để đại diện cho chức năng giảm giá.
- Trong interface **KhuyenMai**, định nghĩa một phương thức **khuyenMai** và truyền vào tỷ lệ phần trăm giảm giá.
- Khi thực hiện giảm giá cho các điện thoại cũ, gọi phương thức **khuyenMai** thông qua interface **KhuyenMai**. Điều này sẽ giúp tất cả các điện thoại cũ giảm giá theo tỷ lệ phần trăm đã được truyền vào.
