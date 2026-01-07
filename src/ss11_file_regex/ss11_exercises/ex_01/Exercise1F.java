package ss11_file_regex.ss11_exercises.ex_01;

import java.io.File;
import java.io.IOException;

public class Exercise1F {
    public static void main(String[] args) throws IOException {
        String oldPath = "src/ss11_file_regex/ss11_exercises/ex_01/data/input.txt";
        String newPath = "src/ss11_file_regex/ss11_exercises/ex_01/data/output.txt";

        File oldFileOrDirectory = new File(oldPath);
        File newFileOrDirectory = new File(newPath);

        if (oldFileOrDirectory.exists()) {
            if (oldFileOrDirectory.renameTo(newFileOrDirectory)) {
                System.out.println("Đã đổi tên thành công.");
            } else {
                System.out.println("Không thể đổi tên.");
            }
        } else {
            System.out.println("Tệp hoặc thư mục không tồn tại.");
        }
    }
}