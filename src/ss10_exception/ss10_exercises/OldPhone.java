package ss10_exception.ss10_exercises;

import ss10_exception.ss10_exercises.validation.PhoneValidation;

import java.util.Scanner;

public class OldPhone extends Phone implements Discountable {
    private int batteryPercentage;
    private String description;

    public OldPhone() {}

    public OldPhone(String id, String name, double price, int warranty,
                    String manufacturer, int batteryPercentage, String description) {
        super(id, name, price, warranty, manufacturer);
        this.batteryPercentage = batteryPercentage;
        this.description = description;
    }

    @Override
    public void input() {
        super.input();
        this.batteryPercentage = PhoneValidation.inputBatteryPercentage("Tình trạng pin (%)");
        this.description = PhoneValidation.inputDescription("Mô tả thêm");
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Tình trạng pin (%): " + this.batteryPercentage);
        System.out.println("Mô tả thêm: " + this.description);
    }

    // Getters and setters

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice();
    }

    @Override
    public void applyDiscount(double percentDiscount) {
        double discountedPrice = getPrice() * (1 - percentDiscount / 100.0);
        setPrice(discountedPrice);
    }
}