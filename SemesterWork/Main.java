package semester_work;

import semester_work.io.FileReader;
import semester_work.sorting.TimSort;

import java.util.List;

public class Main {

    // количество запусков для каждого массива
    private static final int RUNS = 10;
    private static final int WARMUP_RUNS = 5;

    public static void main(String[] args) {
        List<Integer[]> listOfArrays = FileReader.getListOfArrays();
        System.out.println("размер - среднее время (нс) - итерации");

        // прогрев jvm (запуск программы ест время, будет мешать при подсчёте времени)
        Integer[] warmUpArray = listOfArrays.get(0).clone();
        for (int i = 0; i < WARMUP_RUNS; i++) {
            new TimSort<>(warmUpArray).sort();
        }

        for (Integer[] array : listOfArrays) {
            long totalTime = 0;
            int totalIterations = 0;

            // запускаем сортировку RUNS раз
            for (int i = 0; i < RUNS; i++) {
                Integer[] arrayCopy = array.clone();

                // замеряем время начала
                long startTime = System.nanoTime();
                new TimSort<>(arrayCopy).sort();
                // замеряем время конца
                long endTime = System.nanoTime();

                totalTime += (endTime - startTime);
                totalIterations += TimSort.getIterations();
            }

            // усредняем результаты
            long averageTime = totalTime / RUNS;
            int averageIterations = totalIterations / RUNS;
            int arrayLength = array.length;

            System.out.println(arrayLength + " " + averageTime + " " + averageIterations);
        }
    }
}
