package ss10_exception.ss10_exercises.validation;

import ss10_exception.ss10_exercises.exception.EmptyFieldException;
import ss10_exception.ss10_exercises.exception.NumberOutOfRangeException;
import ss10_exception.ss10_exercises.exception.MinLengthException;
import ss10_exception.ss10_exercises.exception.NegativeNumberException;

public class CommonValidation {
    public static void validateIsEmpty(String value, String fieldName) throws EmptyFieldException {
        if (value.isEmpty()) {
            throw new EmptyFieldException(fieldName + " không được trống.");
        }
    }

    public static int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " phải là số nguyên.");
        }
    }

    public static double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " phải là số thực.");
        }
    }

    public static void validateNumberOutOfRangeException(double value, String fieldName, double minValue, double maxValue) throws NumberOutOfRangeException {
        if (value < minValue || value > maxValue) {
            throw new NumberOutOfRangeException(
                    String.format("%s nằm ngoài khoảng giá trị hợp lệ [%s, %s].", fieldName, minValue, maxValue));
        }
    }

    public static void validateMinLength(String value, String fieldName, int minLength) throws MinLengthException {
        if (value.length() < minLength) {
            throw new MinLengthException(String.format("%s phải có ít nhất %s ký tự.", fieldName, minLength));
        }
    }

    public static void validateIsNegativeNumber(double value, String fieldName) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException(fieldName + " không được là số âm.");
        }
    }
}
