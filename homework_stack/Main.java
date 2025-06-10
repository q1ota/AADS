package homework_stack;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        // Создаем обычный стек размером 3
        Stack stack = new Stack(3);

        System.out.println("Примеры с обычным стеком");

        // Добавляем элементы
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Пытаемся добавить в заполненный стек
        boolean result = stack.push(40);
        System.out.println("Попытка добавить 40: " + (result ? "успешно" : "не удалось (стек полон)"));

        // Выводим и удаляем элементы
        System.out.println("Вершина стека: " + stack.peek());
        System.out.println("Удален элемент: " + stack.pop());
        System.out.println("Удален элемент: " + stack.pop());
        System.out.println("Удален элемент: " + stack.pop());

        // Пытаемся удалить из пустого стека
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Ошибка: стек пуст!");
        }

        // Создаем стек с поддержкой минимума размером 4
        MinStack minStack = new MinStack(4);

        System.out.println("\nПримеры со стеком минимумов");

        // Добавляем элементы
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        // Выводим минимумы
        System.out.println("Текущий минимум: " + minStack.getMin());
        System.out.println("Удален элемент: " + minStack.pop());
        System.out.println("Теперь минимум: " + minStack.getMin());

        System.out.println("Удален элемент: " + minStack.pop());
        System.out.println("Теперь минимум: " + minStack.getMin());

        System.out.println("Удален элемент: " + minStack.pop());
        System.out.println("Теперь минимум: " + minStack.getMin());
    }
}