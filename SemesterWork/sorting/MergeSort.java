package semester_work.sorting;

public record MergeSort<T extends Comparable<T>>(T[] arr) {

    // рекурсивное деление массива на части и их слияние
    private void mergesort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    // метод слияния двух отсортированных подмассивов [low..middle] и [middle+1..high]
    void merge(int low, int middle, int high) {

        // создаём временные массивы для хранения копий левой и правой части
        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];

        // копируем элементы во временные массивы
        System.arraycopy(arr, low, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        // индексы для обхода левого, правого и основного массива
        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;

        // пока есть элементы в обоих массивах, сравниваем и вставляем меньший
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0
                    ? leftArray[leftSubArrCounter++]
                    : rightArray[rightSubArrCounter++];
        }

        // добавляем оставшиеся элементы из левого массива, если есть
        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }

        // добавляем оставшиеся элементы из правого массива, если есть
        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }
    }
}
