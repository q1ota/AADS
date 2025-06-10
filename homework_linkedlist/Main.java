package homework_linkedlist;

public class Main {

    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        list.remove("Hello");
        System.out.println(list.get(1));
    }
}