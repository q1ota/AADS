package semester_work_2.Tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    List<Integer> values = new ArrayList<>();
    List<Node> children = new ArrayList<>();
    boolean isLeaf = true;

    boolean isOverflow() {
        return values.size() > 2;
    }

    SplitResult split() {
        int promotedValue = values.get(1); // Среднее значение

        Node left = new Node();
        left.values.add(values.get(0));

        Node right = new Node();
        right.values.add(values.get(2));

        if (!isLeaf) {
            left.children.add(children.get(0));
            left.children.add(children.get(1));
            right.children.add(children.get(2));
            right.children.add(children.get(3));
            left.isLeaf = false;
            right.isLeaf = false;
        }

        return new SplitResult(promotedValue, left, right);
    }

    void addValue(int value) {
        // вставка с сохранением порядка
        int pos = 0;
        while (pos < values.size() && value > values.get(pos)) pos++;
        values.add(pos, value);
    }
}