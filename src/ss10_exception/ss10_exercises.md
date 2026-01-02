# Ứng dụng quản lý điện thoại

## Xây dựng tiếp các chức năng sau

a. Tạo ra một **EmptyFieldException** để kiểm tra **tất cả các trường không được phép trống**.

b. Sử dụng **NumberFormatException** có sẵn của Java để kiểm tra **giá, thời gian bảo hành, tình trạng pin, số lượng** phải là số.

c. Tạo ra một **NumberOutOfRangeException** khi thông tin về **tình trạng pin của điện thoại cũ** không thuộc phạm vi **0–100%**.

d. Tạo ra một **MinLengthException** khi **mô tả thêm của điện thoại cũ** là rỗng hoặc quá ngắn (**dưới 10 ký tự**).

e. Tạo ra một **NegativeNumberException** khi **giá, thời gian bảo hành, số lượng** là một số âm.

f. Ngoài ra, trong trường hợp xuất hiện **bất kỳ exception ngoại lệ nào khác**, chương trình sẽ thông báo:  
**"Ứng dụng gặp một số lỗi không mong muốn, xin vui lòng thử lại các chức năng."**
