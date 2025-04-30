package semester_work.sorting;

public record TimSort<T extends Comparable<T>>(T[] arr) {

    // минимальный размер подмассива, который сортируется вставками
    private static final int MIN_RUN_SIZE = 32;

    // счётчик итераций
    private static int iterations = 0;

    public void sort() {
        // обнуляем счётчик итераций перед сортировкой
        iterations = 0;

        // проходим по массиву кусками по MIN_RUN_SIZE и сортируем каждый вставками
        for (int start = 0; start < arr.length; start += MIN_RUN_SIZE) {
            iterations++;
            int end = Math.min((start + MIN_RUN_SIZE - 1), (arr.length - 1));
            new InsertionSort<>(arr).sort(start, end);
        }

        // постепенно объединяем отсортированные подмассивы, удваивая размер "рана" на каждой итерации
        for (int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {
            for (int left = 0; left < arr.length; left += 2 * runSize) {
                iterations++;
                int mid = left + runSize - 1;
                int right = Math.min((left + 2 * runSize - 1), (arr.length - 1));
                // объединяем только если правый подмассив существует
                if (mid < right) {
                    new MergeSort<>(arr).merge(left, mid, right);
                    iterations++;
                }
            }
        }
    }

    // возвращает общее количество итераций
    public static int getIterations() {
        return iterations;
    }
}
