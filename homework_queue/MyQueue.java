package homework_queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> helpStack;

    public MyQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void add(int number) {
        mainStack.push(number);
    }

    public int removed() {
        if(!helpStack.isEmpty()) {
            return helpStack.pop();
        } else if(!mainStack.isEmpty()) {
            reverse();
        } else {
            throw new NullPointerException();
        }
        return helpStack.pop();
    }

    public int peek() {
        if (!helpStack.isEmpty()) {
            return helpStack.peek();
        } else if (!mainStack.isEmpty()) {
            reverse();
            return helpStack.peek();
        } else {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private void reverse() {
        while(!mainStack.isEmpty()) {
            helpStack.push(mainStack.pop());
        }
    }

    public boolean isEmpty() {
        return mainStack.isEmpty() && helpStack.isEmpty();
    }
}
