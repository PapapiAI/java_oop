package ss1_oop_overview.exercises.exe3;

public class DistanceCalculator {
    public static void main(String[] args) {
        Point point1 = new Point();
        Point point2 = new Point();

        System.out.println("Nhập tọa độ của điểm thứ nhất:");
        point1.input();

        System.out.println("Nhập tọa độ của điểm thứ hai:");
        point2.input();

        double distance = point1.distanceTo(point2);

        System.out.println("Khoảng cách giữa hai điểm là: " + distance);
    }
}
