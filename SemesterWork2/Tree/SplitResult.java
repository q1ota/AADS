package semester_work_2.Tree;

class SplitResult {
    int promotedValue;
    Node left;
    Node right;

    SplitResult(int promoted, Node l, Node r) {
        promotedValue = promoted;
        left = l;
        right = r;
    }
}