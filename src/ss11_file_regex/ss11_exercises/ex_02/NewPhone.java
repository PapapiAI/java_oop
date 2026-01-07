package ss11_file_regex.ss11_exercises.ex_02;

import ss11_file_regex.ss11_exercises.ex_02.validation.PhoneValidation;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
    }

    public NewPhone(String id, String name, double price, int warranty,
                    String manufacturer, int quantity) {
        super(id, name, price, warranty, manufacturer);
        this.quantity = quantity;
    }

    @Override
    public void input() {
        super.input();
        this.quantity = PhoneValidation.inputQuantity("Số lượng");
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Số lượng: " + this.quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }

    // Getters and setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",,,%s", quantity); 
        // Lưu ý: Chuỗi format có vẻ đang map theo số lượng dấu phẩy trong file CSV tổng
    }
}
