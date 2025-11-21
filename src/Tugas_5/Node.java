package Tugas_5;

class Node {
    int key;
    Node left, right, parent;
    boolean isRed;  // true = RED, false = BLACK

    Node(int key) {
        this.key = key;
        this.isRed = true;
        this.left = this.right = this.parent = null;
    }
}