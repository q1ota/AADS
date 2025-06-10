package homework_stack;

import java.util.EmptyStackException;

// Стек с поддержкой минимума
class MinStack {
    private final Stack mainStack;    // Основной стек
    private final Stack minStack;     // Вспомогательный стек для минимумов

    public MinStack(int size) {
        this.mainStack = new Stack(size);
        this.minStack = new Stack(size);
    }

    public boolean push(int value) {
        // Добавляем в основной стек
        if (!mainStack.push(value)) {
            return false;
        }

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
        return true;
    }

    public int pop() {
        minStack.pop();  // Удаляем из стека минимумов
        return mainStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new EmptyStackException();
        return minStack.peek();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
}