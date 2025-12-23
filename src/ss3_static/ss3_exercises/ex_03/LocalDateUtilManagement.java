package ss3_static.ss3_exercises.ex_03;

import java.time.LocalDate;

public class LocalDateUtilManagement {
    public static void main(String[] args) {
        // Chuyển đổi chuỗi thành LocalDate
        String dateString1 = "15/09/2023";
        String dateString2 = "2023/09/15";

        LocalDate date1 = LocalDateUtil.fromString_ddMMyyyy(dateString1);
        LocalDate date2 = LocalDateUtil.fromString_yyyyMMdd(dateString2);

        System.out.println("LocalDate từ chuỗi dd/MM/yyyy: " + date1);
        System.out.println("LocalDate từ chuỗi yyyy/MM/dd: " + date2);

        // Chuyển đổi LocalDate thành chuỗi
        LocalDate currentDate = LocalDate.now();

        String formattedDate1 = LocalDateUtil.toString_ddMMyyyy(currentDate);
        String formattedDate2 = LocalDateUtil.toString_yyyyMMdd(currentDate);

        System.out.println("Chuỗi từ LocalDate (dd/MM/yyyy): " + formattedDate1);
        System.out.println("Chuỗi từ LocalDate (yyyy/MM/dd): " + formattedDate2);
    }
}