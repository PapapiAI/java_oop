package ss11_file_regex.ss11_exercises.ex_01;

import java.io.File;
import java.io.IOException;

public class Exercise1D {
    public static void main(String[] args) throws IOException {
        // path là đường dẫn cần kiểm tra
        String path = "src/ss11_file_regex/ss11_exercises/ex_01/data/input.txt";

        File file = new File(path);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Đường dẫn trỏ đến một tệp.");
            } else if (file.isDirectory()) {
                System.out.println("Đường dẫn trỏ đến một thư mục.");
            } else {
                System.out.println("Đường dẫn tồn tại nhưng không phải là tệp hoặc thư mục.");
            }
        } else {
            System.out.println("Đường dẫn không tồn tại.");
        }
    }
}