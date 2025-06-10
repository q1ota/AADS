package homework_queue;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Добавление элементов
        System.out.println("\nДобавляем элементы:");
        queue.add(10);
        System.out.println("Добавлен: 10");
        queue.add(20);
        System.out.println("Добавлен: 20");
        queue.add(30);
        System.out.println("Добавлен: 30");

        // Просмотр первого элемента
        System.out.println("\nПервый элемент (peek): " + queue.peek());

        // Удаление элементов
        System.out.println("\nУдаляем элементы:");
        System.out.println("Удален: " + queue.removed());
        System.out.println("Удален: " + queue.removed());

        // Добавляем еще элементы
        System.out.println("\nДобавляем новые элементы:");
        queue.add(40);
        System.out.println("Добавлен: 40");
        queue.add(50);
        System.out.println("Добавлен: 50");

        // Проверка очереди
        System.out.println("\nСостояние очереди:");
        System.out.println("Первый элемент (peek): " + queue.peek());
        System.out.println("Очередь пуста? " + queue.isEmpty());

        // Очистка очереди
        System.out.println("\nОчищаем очередь:");
        while(!queue.isEmpty()) {
            System.out.println("Удален: " + queue.removed());
        }

        // Проверка пустой очереди
        System.out.println("\nТестирование пустой очереди:");
        System.out.println("Очередь пуста? " + queue.isEmpty());

        try {
            queue.peek();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("При peek() на пустой очереди: " + e.getMessage());
        }

        try {
            queue.removed();
        } catch (NullPointerException e) {
            System.out.println("При removed() на пустой очереди: NullPointerException");
        }
    }
}