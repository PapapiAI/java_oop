package ss11_file_regex.ss11_exercises.ex_02.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ss11_file_regex.ss11_exercises.ex_02.NewPhone;
import ss11_file_regex.ss11_exercises.ex_02.OldPhone;
import ss11_file_regex.ss11_exercises.ex_02.Phone;

public class ReadFileUtil {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        bufferedReader.readLine(); // Loại bỏ tiêu đề
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();

        return strings;
    }

    public static List<Phone> readPhonesFile(String path) throws IOException {
        List<String> lines = readFile(path);
        List<Phone> phones = new ArrayList<>();
        Phone phone;
        String[] info;
        for (String line : lines) {
            info = line.split(",");
            if (info[0].startsWith("DTC")) {
                OldPhone oldPhone = new OldPhone();
                oldPhone.setBatteryPercentage(Integer.parseInt(info[5]));
                oldPhone.setDescription(info[6]);

                phone = oldPhone;
            } else {
                NewPhone newPhone = new NewPhone();
                newPhone.setQuantity(Integer.parseInt(info[7]));

                phone = newPhone;
            }

            phone.setId(info[0]);
            phone.setName(info[1]);
            phone.setPrice(Double.parseDouble(info[2]));
            phone.setWarranty(Integer.parseInt(info[3]));
            phone.setManufacturer(info[4]);

            phones.add(phone);
        }

        return phones;
    }
}