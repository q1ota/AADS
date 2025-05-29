package semester_work_2.Tree;

public class TwoThreeTree {
    private Node root;

    // для замера операций
    public long operationCount = 0;

    public void resetOperationCount() {
        operationCount = 0;
    }

    public long getOperationCount() {
        return operationCount;
    }

    public void insert(int value) {
        resetOperationCount();
        if (root == null) {
            root = new Node();
            root.addValue(value);
            return;
        }

        SplitResult result = insert(root, value);
        if (result != null) {
            Node newRoot = new Node();
            newRoot.addValue(result.promotedValue);
            newRoot.children.add(result.left);
            newRoot.children.add(result.right);
            newRoot.isLeaf = false;
            root = newRoot;
        }
    }

    private SplitResult insert(Node node, int value) {
        operationCount++; // счёт операций
        if (node.isLeaf) {
            node.addValue(value);
            if (node.isOverflow()) {
                return node.split();
            }
            return null;
        } else {
            int i = 0;
            while (i < node.values.size() && value > node.values.get(i)) {
                i++;
                operationCount++;
            }
            SplitResult childResult = insert(node.children.get(i), value);
            if (childResult != null) {
                node.addValue(childResult.promotedValue);
                node.children.set(i, childResult.left);
                node.children.add(i + 1, childResult.right);
                if (node.isOverflow()) {
                    return node.split();
                }
            }
            return null;
        }
    }

    public boolean search(int value) {
        resetOperationCount();
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) return false;
        int i = 0;
        while (i < node.values.size() && value > node.values.get(i)) {
            i++;
            operationCount++;
        }
        if (i < node.values.size() && value == node.values.get(i)) {
            operationCount++;
            return true;
        }
        if (node.isLeaf) {
            return false;
        } else {
            return search(node.children.get(i), value);
        }
    }

    public void delete(int value) {
        resetOperationCount();
        // реализация удаления может быть сложной в 2-3 дереве
        // для учебных целей можно просто не реализовывать балансировку после удаления
        delete(root, value);
    }

    private void delete(Node node, int value) {
        if (node == null) return;

        int i = 0;
        while (i < node.values.size() && value > node.values.get(i)) {
            i++;
            operationCount++;
        }

        if (i < node.values.size() && value == node.values.get(i)) {
            if (node.isLeaf) {
                node.values.remove(i); // просто удаляем из листа
            } else {
                // найдём преемника
                Node successor = node.children.get(i + 1);
                if (successor == null || successor.values.isEmpty()) return; // защита

                while (!successor.isLeaf && !successor.children.isEmpty()) {
                    successor = successor.children.get(0);
                    operationCount++;
                }

                if (successor.values.isEmpty()) return; // дополнительная защита

                int successorValue = successor.values.get(0);
                node.values.set(i, successorValue);
                delete(node.children.get(i + 1), successorValue);
            }
        } else if (!node.isLeaf && i < node.children.size()) {
            delete(node.children.get(i), value);
        }
    }

    // пример обхода дерева (in-order)
    public void traverse() {
        traverse(root);
        System.out.println(); // для перевода строки после вывода
    }

    private void traverse(Node node) {
        if (node == null) return;

        if (node.isLeaf) {
            // вывод всех значений листа
            for (int value : node.values) {
                System.out.print(value + " ");
            }
        } else {
            // рекурсивный обход детей с выводом значений между ними
            for (int i = 0; i < node.children.size(); i++) {
                traverse(node.children.get(i));
                if (i < node.values.size()) {
                    System.out.print(node.values.get(i) + " ");
                }
            }
        }
    }

    // метод для вывода графика дерева
    public void printTree() {
        printTree(root, 0, "", true);
    }

    private void printTree(Node node, int level, String prefix, boolean isLeft) {
        if (node == null) return;

        // правый (самый последний) потомок — печатаем наверху
        if (node.children.size() > 1) {
            printTree(node.children.get(node.children.size() - 1),
                    level + 1,
                    prefix + (isLeft ? "│   " : "    "),
                    false);
        }

        // текущий узел
        System.out.print(prefix);
        System.out.println((isLeft ? "└── " : "┌── ") + node.values);

        // левые потомки в обратном порядке — сначала children[size-2], ..., потом children[0]
        for (int i = node.children.size() - 2; i >= 0; i--) {
            printTree(node.children.get(i),
                    level + 1,
                    prefix + (isLeft ? "    " : "│   "),
                    true);
        }
    }

}
