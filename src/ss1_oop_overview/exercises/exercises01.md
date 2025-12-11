# Bài tập 1: Quản lý thông tin học sinh

## Đề bài

> Viết chương trình cho phép nhập thông tin học sinh, bao gồm:
> * Các thuộc tính: tên học sinh, điểm toán, và điểm văn
> * Tính điểm trung bình và hiển thị kết quả

### Hướng dẫn các bước thực hiện

#### Bước 1: Tạo lớp Student với các thuộc tính và phương thức cần thiết

* Thuộc tính: `name` (Tên học sinh), `mathScore` (điểm toán), `literatureScore` (điểm văn)
* Phương thức:
    * `input()`: Nhập thông tin học sinh từ bàn phím, sử dụng `System.out.print` để hiển thị hướng dẫn nhập và `Scanner`
      để đọc dữ liệu từ bàn phím
    * `calculateAverageScore()`: Tính điểm trung bình
    * `output()`: Xuất thông tin học sinh và điểm trung bình ra màn hình

#### Bước 2: Tạo lớp chứa phương thức main để thực thi chương trình

* Khởi tạo một đối tượng của lớp `Student`
* Gọi phương thức `input()` để nhập thông tin học sinh
* Gọi phương thức `output()` để hiển thị thông tin và điểm trung bình

---

# Bài tập 2: Xử lý phân số

## Đề bài

> Viết chương trình nhập vào một phân số (gồm tử & mẫu):
> * a. Viết method nhập, xuất cho phân số
>   * i. Đối với method nhập sẽ không cho nhập mẫu vào số 0
>   * ii. Đối với method xuất nên ở dạng rút gọn nhất (2/8 nên là 1/4, 8/-4 nên là -2, ...)
> * b. Tính Tổng, Hiệu, tích thương của 2 phân số
> * c. Hãy cho biết phân số đó là phân số âm hay dương hay bằng không

### Mô tả

Chúng ta sẽ tạo một lớp `PhanSo` chứa thông tin về tử số và mẫu số của phân số. Lớp này sẽ chứa các phương thức để nhập, xuất, và thực hiện các phép toán cơ bản trên phân số

### Hướng dẫn các bước thực hiện

#### a. Viết method nhập, xuất cho phân số

* Phương thức nhập:
  * Sử dụng `Scanner` để đọc dữ liệu từ bàn phím
  * Sử dụng vòng lặp `do-while` để đảm bảo mẫu số không bằng 0
* Phương thức xuất:
  * Rút gọn phân số trước khi xuất
  * Tìm ước chung lớn nhất của tử số và mẫu số
  * Chia tử số và mẫu số cho ước chung lớn nhất
* Kiểm tra mẫu số:
  * Nếu mẫu số âm, thì lấy tử số = -tử số, mẫu s
  * Nếu mẫu số bằng 1, chỉ cần xuất tử số

#### b. Tính Tổng, Hiệu, tích thương của 2 phân số

* Phương thức cộng:
    * Tính tử số và mẫu số của tổng hai phân số
* Phương thức trừ:
    * Tính tử số và mẫu số của hiệu hai phân số
* Phương thức nhân:
    * Tính tử số và mẫu số của tích hai phân số
* Phương thức chia:
    * Tính tử số và mẫu số của thương hai phân số

#### c. Hãy cho biết phân số đó là phân số âm hay dương hay bằng không

* Phương thức kiểm tra phân số dương:
    * Nếu tử số và mẫu số cùng dấu hoặc tử số = 0, phân số là dương. Ngược lại, nó là âm
* Phương thức kiểm tra phân số bằng không:
    * Nếu tử số bằng 0, phân số bằng 0

---

# Bài tập 3: Xử lý tọa độ và khoảng cách giữa hai điểm

## Đề bài

> Viết chương trình nhập vào tọa độ của hai điểm trong mặt phẳng OXY và tính khoảng cách giữa hai điểm đó

### Mô tả

* Chúng ta sẽ tạo một lớp Point chứa thông tin về tọa độ X và Y của một điểm trên mặt phẳng
* Lớp này cũng sẽ chứa phương thức để nhập tọa độ điểm và một phương thức tính khoảng cách giữa hai điểm

### Hướng dẫn các bước thực hiện

#### Lớp Point

* Thuộc tính:
  * `x`: Tọa độ X của điểm
  * `y`: Tọa độ Y của điểm
* Phương thức:
  * `input()`: Để nhập tọa độ điểm từ bàn phím
  * `distanceTo(Point other)`: Tính và trả về khoảng cách giữa điểm hiện tại và một điểm khác

#### Phương thức `distanceTo(Point other)`:

* Sử dụng công thức tính khoảng cách giữa hai điểm:
  * `distance = √((x2 - x1)^2 + (y2 - y1)^2)`
  * Trong đó, `(x1, y1)` và `(x2, y2)` là tọa độ của hai điểm


