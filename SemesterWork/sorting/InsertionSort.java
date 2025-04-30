package semester_work.sorting;

public record InsertionSort<T extends Comparable<T>>(T[] arr) {

    // сортировка подмассива от start до end включительно
    public void sort(int start, int end) {
        // идём по массиву от start до end
        for (int i = start; i <= end; i++) {
            int j = i;
            // сдвигаем элемент влево, пока он меньше предыдущего
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                // меняем элементы местами
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
