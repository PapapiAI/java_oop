package ss11_file_regex.ss11_exercises.ex_02.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ss11_file_regex.ss11_exercises.ex_02.Phone;

public class WriteFileUtil {
    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writePhonesFile(String path, List<Phone> phones) throws IOException {
        StringBuilder data = new StringBuilder("ID,Tên điện thoại,Giá bán,Thời gian bảo hành," +
                "Hãng sản xuất,Tình trạng pin (%),Mô tả thêm,Số lượng");
        for (Phone phone : phones) {
            data.append("\n").append(phone.toString());
        }

        writeFile(path, data.toString());
    }
}