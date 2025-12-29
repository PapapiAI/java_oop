package ss2_constructor.exercises.ex_02;

public class ThoiGian {
    private int gio;  // Giờ
    private int phut; // Phút
    private int giay; // Giây

    // Constructor Mặc định: Khởi tạo thời gian 00:00:00.
    public ThoiGian() {
        gio = 0;
        phut = 0;
        giay = 0;
    }

    // Constructor 1 tham số: Khởi tạo thời gian với giờ cho trước và phút, giây mặc định là 00.
    public ThoiGian(int gio) {
        this.gio = gio;
        phut = 0;
        giay = 0;
    }

    // Constructor 2 tham số: Khởi tạo thời gian với giờ, phút cho trước và giây mặc định là 00.
    public ThoiGian(int gio, int phut) {
        this.gio = gio;
        this.phut = phut;
        giay = 0;
    }

    // Constructor 3 tham số: Khởi tạo thời gian với giờ, phút, giây cho trước.
    public ThoiGian(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    // Constructor sao chép: Khởi tạo thời gian dựa vào một đối tượng ThoiGian khác.
    public ThoiGian(ThoiGian other) {
        this.gio = other.gio;
        this.phut = other.phut;
        this.giay = other.giay;
    }

    // Phương thức xuất()
    public void xuat() {
        System.out.printf("%02d:%02d:%02d\n", gio, phut, giay);
        // "%02d": Định dạng một giá trị số nguyên (d là số nguyên)
        // sao cho nó hiển thị ít nhất 2 chữ số (bao gồm số 0 ở phía trước nếu cần).
        // Ví dụ, nếu giá trị là 5, nó sẽ hiển thị là "05", và nếu giá trị là 12, nó vẫn hiển thị là "12".
    }
}
