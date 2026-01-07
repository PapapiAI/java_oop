package ss11_file_regex.ss11_exercises.ex_01;

import java.io.File;
import java.io.IOException;

public class Exercise1E {
    public static void main(String[] args) throws IOException {
        // path là đường dẫn cần xóa
        String path = "src/ss11_file_regex/ss11_exercises/ex_01/data/output.txt";

        File fileToDelete = new File(path);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Đã xóa thành công: " + path);
            } else {
                System.out.println("Không thể xóa: " + path);
            }
        } else {
            System.out.println("Đường dẫn không tồn tại: " + path);
        }
    }
}