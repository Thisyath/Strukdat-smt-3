package AVLTree_khusus;

class Node {
    char key;
    Node left, right, parent;
    int height  = 1;  // tinggi subtree

    Node(char key) {
        this.key = key;
    }
}