package homework_hashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Key, String> map = new MyHashMap<>();

        Key key1 = new Key("apple");
        Key key2 = new Key("banana");

        map.put(key1, "Яблоко");
        map.put(key2, "Банан");

        // Основные операции
        System.out.println("Значение для 'apple': " + map.get(key1));
        System.out.println("Есть ли 'banana'? " + map.containsKey(key2));

        // Обновление значения
        map.put(key1, "Зеленое яблоко");
        System.out.println("Обновленное значение для 'apple': " + map.get(key1));

        // Удаление
        map.remove(key2);
        System.out.println("Есть ли 'banana' после удаления? " + map.containsKey(key2));
    }
}