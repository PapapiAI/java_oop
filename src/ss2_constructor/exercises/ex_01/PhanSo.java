package ss2_constructor.exercises.ex_01;

public class PhanSo {
    private int tuSo; // Tử số của phân số
    private int mauSo; // Mẫu số của phân số

    // Constructor Mặc định: Khởi tạo phân số 0 với tử số 0 và mẫu số là 1.
    public PhanSo() {
        tuSo = 0;
        mauSo = 1;
    }

    // Constructor 1 tham số: Khởi tạo phân số với tử số cho trước và mẫu số là 1.
    public PhanSo(int tuSo) {
        this.tuSo = tuSo;
        mauSo = 1;
    }

    // Constructor 2 tham số: Khởi tạo phân số với tử số và mẫu số cho trước.
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon(); // Rút gọn phân số ngay sau khi khởi tạo
    }

    // Tìm ước chung lớn nhất
    private int uocChungLonNhat(int a, int b) {
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

    // Phương thức rút gọn phân số
    private void rutGon() {
        int ucln = uocChungLonNhat(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;

        // Đảm bảo mẫu số luôn là dương
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    // Phương thức xuất phân số
    public void xuat() {
        if (mauSo == 1) {
            System.out.println(tuSo);
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }

    // Phương thức sao chép
    public PhanSo copy() {
        return new PhanSo(tuSo, mauSo);
    }

    // Phương thức cộng với một số
    public void cong(int value) {
        tuSo += value * mauSo;
        rutGon();
    }
}
