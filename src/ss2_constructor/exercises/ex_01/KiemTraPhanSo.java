package ss2_constructor.exercises.ex_01;

public class KiemTraPhanSo {
    public static void main(String[] args) {
        PhanSo a = new PhanSo();
        a.xuat(); // 0

        PhanSo b = new PhanSo(1, 2);
        b.xuat(); // 1/2

        PhanSo c = new PhanSo(3);
        c.xuat(); // 3

        PhanSo d = new PhanSo(-6, -2);
        d.xuat(); // 3

        PhanSo e = new PhanSo(3, -1);
        e.xuat(); // -3

        PhanSo f = e.copy();
        f.cong(100);
        e.xuat(); // -3
        f.xuat(); // 97
    }
}
