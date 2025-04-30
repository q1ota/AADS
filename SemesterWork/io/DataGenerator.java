package semester_work.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) throws IOException {

        // путь, где создастся txt документ и имя
        File file = new File("C:/Users/User/Desktop", "RandomArraysFile.txt");
        FileWriter fileWriter = new FileWriter(file);
        Random random = new Random();

        // назначаем кол-во массивов (от 50 до 100)
        int numberOfArrays = random.nextInt(51) + 50;

        // для каждого массива назначаем кол-во элементов (от 100 до 10_000)
        for (int i = 0; i < numberOfArrays; i++) {
            int size = random.nextInt(9901) + 100;
            int[] array = new int[size];

            // заполняем массив числами от -1000 до 1000
            for (int j = 0; j < size; j++) {
                array[j] = random.nextInt(2001) - 1000;
                // и сразу же заполняем эти элементы массива в файл
                fileWriter.write(array[j] + " ");
            }
            // как заполнили массив, ставим отступ "\n"
            fileWriter.write("\n");
        }
    }
}