package ss3_static.ss3_exercises.ex_02;

public class MathUtil {

    // Phương thức tĩnh để cộng hai số
    public static double add(double a, double b) {
        return a + b;
    }

    // Phương thức tĩnh để trừ hai số
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Phương thức tĩnh để nhân hai số
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Phương thức tĩnh để chia hai số
    public static double divide(double a, double b) {
        if (b == 0) {
            return -1;
        }
        return a / b;
    }
}
