package ss11_file_regex.ss11_exercises.ex_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1B {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ss11_file_regex/ss11_exercises/ex_01/data/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null && count++ < 3) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}