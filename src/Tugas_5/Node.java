package Tugas_5;

class Node {
    char key;
    Node left, right, parent;
    boolean isRed;  // true = RED, false = BLACK

    public Node(char key) {
        this.key = key;
        this.isRed = true;     // node baru selalu merah
        this.left = this.right = this.parent = null;
    }
}