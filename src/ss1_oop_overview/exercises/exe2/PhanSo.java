package ss1_oop_overview.exercises.exe2;

import java.util.Scanner;

public class PhanSo {
    int tuSo;   // Tử số
    int mauSo;  // Mẫu số

    // Phương thức nhập phân số từ bàn phím
    void nhap() {
        Scanner scanner = new Scanner(System.in);

        // Nhập tử số
        System.out.print("Nhập tử số: ");
        tuSo = scanner.nextInt();

        // Nhập mẫu số và kiểm tra mẫu số khác 0
        do {
            System.out.print("Nhập mẫu số (khác 0): ");
            mauSo = scanner.nextInt();
        } while (mauSo == 0);
    }

    // Phương thức rút gọn phân số
    void rutGon() {
        int ucln = uocChungLonNhat(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;

        // Đảm bảo mẫu số luôn là dương
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    // Tìm ước chung lớn nhất
    int uocChungLonNhat(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        a = Math.abs(a);

        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }

    // Phương thức xuất phân số ở dạng rút gọn
    void xuat() {
        rutGon();
        if (mauSo == 1) {
            System.out.println(tuSo); // Nếu mẫu số là 1, chỉ cần xuất tử số.
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }

    // Phương thức tính tổng hai phân số
    PhanSo cong(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo + phanSoKhac.tuSo * this.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    // Phương thức tính hiệu hai phân số
    PhanSo tru(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo - phanSoKhac.tuSo * this.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    // Phương thức tính tích hai phân số
    PhanSo nhan(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.tuSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.mauSo;
        return ketQua;
    }

    // Phương thức tính thương hai phân số
    PhanSo chia(PhanSo phanSoKhac) {
        PhanSo ketQua = new PhanSo();
        ketQua.tuSo = this.tuSo * phanSoKhac.mauSo;
        ketQua.mauSo = this.mauSo * phanSoKhac.tuSo;
        return ketQua;
    }

    // Phương thức kiểm tra phân số dương
    boolean laPhanSoDuong() {
        return tuSo * mauSo > 0 || tuSo == 0; // Nếu tử số và mẫu số cùng dấu hoặc tử số = 0, phân số là dương
    }

    // Phương thức kiểm tra phân số bằng không
    boolean laPhanSoKhong() {
        return tuSo == 0; // Nếu tử số bằng 0, phân số bằng 0
    }
}
