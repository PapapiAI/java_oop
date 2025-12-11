package ss1_oop_overview.exercises.exe2;

public class KiemTraPhanSo {
    public static void main(String[] args) {
        PhanSo phanSo1 = new PhanSo();
        PhanSo phanSo2 = new PhanSo();

        System.out.println("Nhập phân số thứ nhất:");
        phanSo1.nhap(); // Gọi phương thức nhập để nhập thông tin cho phân số thứ nhất

        System.out.println("Nhập phân số thứ hai:");
        phanSo2.nhap(); // Gọi phương thức nhập thông tin cho phân số thứ hai

        System.out.println("Phân số thứ nhất: ");
        phanSo1.xuat(); // Gọi phương thức xuất để hiển thị thông tin của phân số thứ nhất

        System.out.println("Phân số thứ hai: ");
        phanSo2.xuat(); // Gọi phương thức xuất để hiển thị thông tin của phân số thứ hai

        System.out.print("Tổng hai phân số: ");
        PhanSo tong = phanSo1.cong(phanSo2); // Gọi phương thức cộng để tính tổng hai phân số
        tong.xuat(); // Gọi phương thức xuất để hiển thị kết quả tổng

        System.out.print("Hiệu hai phân số: ");
        PhanSo hieu = phanSo1.tru(phanSo2); // Gọi phương thức trừ để tính hiệu hai phân số
        hieu.xuat(); // Gọi phương thức xuất để hiển thị kết quả hiệu

        System.out.print("Tích hai phân số: ");
        PhanSo tich = phanSo1.nhan(phanSo2); // Gọi phương thức nhân để tính tích hai phân số
        tich.xuat(); // Gọi phương thức xuất để hiển thị kết quả tích

        System.out.print("Thương hai phân số: ");
        PhanSo thuong = phanSo1.chia(phanSo2); // Gọi phương thức chia để tính thương hai phân số
        thuong.xuat(); // Gọi phương thức xuất để hiển thị kết quả thương

        // Kiểm tra và hiển thị xem phân số thứ nhất có phải là phân số dương hay không
        System.out.println("Phân số thứ nhất là phân số " + (phanSo1.laPhanSoDuong() ? "dương" : "âm") + ".");

        // Kiểm tra và hiển thị xem phân số thứ hai có phải là phân số dương hay không
        System.out.println("Phân số thứ hai là phân số " + (phanSo2.laPhanSoDuong() ? "dương" : "âm") + ".");

        // Kiểm tra và hiển thị xem phân số thứ nhất có phải là phân số bằng không hay không
        System.out.println("Phân số thứ nhất " + (phanSo1.laPhanSoKhong() ? "bằng không" : "không bằng không") + ".");

        // Kiểm tra và hiển thị xem phân số thứ hai có phải là phân số bằng không hay không
        System.out.println("Phân số thứ hai " + (phanSo2.laPhanSoKhong() ? "bằng không" : "không bằng không") + ".");
    }
}
