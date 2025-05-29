package semester_work_2;

import semester_work_2.Tree.TwoThreeTree;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        TwoThreeTree tree = new TwoThreeTree();
        Random random = new Random();
        // генерация 10_000 случайных чисел
        int[] array = new int[10_000];
        for (int i = 0; i < 10_000; i++) {
            array[i] = random.nextInt(100_000);
        }

        // вставка с замером времени и операций
        long totalInsertTime = 0;
        long totalInsertOps = 0;
        for (int value : array) {
            long start = System.nanoTime();
            tree.insert(value);
            long end = System.nanoTime();
            totalInsertTime += (end - start);
            totalInsertOps += tree.getOperationCount();
        }

        // поиск 100 случайных значений
        long totalSearchTime = 0;
        long totalSearchOps = 0;
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(array.length);
            int value = array[index];
            long start = System.nanoTime();
            tree.search(value);
            long end = System.nanoTime();
            totalSearchTime += (end - start);
            totalSearchOps += tree.getOperationCount();
        }

        // удаление 1000 случайных значений
        long totalDeleteTime = 0;
        long totalDeleteOps = 0;
        for (int i = 0; i < 1000; i++) {
            int index = random.nextInt(array.length);
            int value = array[index];
            long start = System.nanoTime();
            tree.delete(value);
            long end = System.nanoTime();
            totalDeleteTime += (end - start);
            totalDeleteOps += tree.getOperationCount();
        }

        // отрисовка дерева
//        tree.printTree();

        // средние значения
        System.out.println("Среднее время вставки: " + totalInsertTime + " нс");
        System.out.println("Среднее кол-во операций вставки: " + totalInsertOps);
        System.out.println();
        System.out.println("Среднее время поиска: " + totalSearchTime + " нс");
        System.out.println("Среднее кол-во операций поиска: " + totalSearchOps);
        System.out.println();
        System.out.println("Среднее время удаления: " + totalDeleteTime + " нс");
        System.out.println("Среднее кол-во операций удаления: " + totalDeleteOps);
    }
}
