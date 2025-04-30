package semester_work.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<Integer[]> getListOfArrays() {
        ArrayList<Integer[]> listOfArrays = new ArrayList<>();
        try {
            // cчитываем файл в integers
            File file = new File("C:/Users/User/Desktop/RandomArraysFile.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] stringNumbers = line.trim().split(" ");

                Integer[] integers = new Integer[stringNumbers.length];
                for (int i = 0; i < stringNumbers.length; i++) {
                    integers[i] = Integer.parseInt(stringNumbers[i]);
                }
                listOfArrays.add(integers);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
        return listOfArrays;
    }
}
