package ss1_oop_overview.exercises.exe3;

import java.util.Scanner;

public class Point {
    double x;
    double y;

    // Phương thức để nhập tọa độ điểm từ bàn phím
    void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tọa độ X: ");
        x = scanner.nextDouble();

        System.out.print("Nhập tọa độ Y: ");
        y = scanner.nextDouble();
    }

    // Phương thức để tính khoảng cách giữa điểm hiện tại và một điểm khác
    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }
}
