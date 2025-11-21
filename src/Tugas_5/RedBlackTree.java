package Tugas_5;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private Node root;
    private final Node NIL;
    private final ArrayList<Integer> insertOrder = new ArrayList<>();

    public RedBlackTree() {
        NIL = new Node(0);
        NIL.isRed = false;
        root = NIL;
    }

    public void clear() {
        root = NIL;
        insertOrder.clear();
    }

    public boolean insert(int key) {
        Node z = new Node(key);
        Node y = NIL;
        Node x = root;

        while (x != NIL) {
            y = x;
            if (z.key < x.key) x = x.left;
            else if (z.key > x.key) x = x.right;
            else return false;
        }

        z.parent = y;
        if (y == NIL) root = z;
        else if (z.key < y.key) y.left = z;
        else y.right = z;

        z.left = z.right = NIL;
        insertOrder.add(key);
        fixInsert(z);
        return true;
    }

    private void fixInsert(Node z) {
        while (z.parent != NIL && z.parent.isRed) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == NIL) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == NIL) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;
        x.right = y;
        y.parent = x;
    }

    public boolean contains(int key) {
        Node curr = root;
        while (curr != NIL) {
            if (key == curr.key) return true;
            curr = key < curr.key ? curr.left : curr.right;
        }
        return false;
    }

    // VISUALISASI HORIZONTAL SEMPURNA (seperti buku)
    public void printTree() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println(" ".repeat(30) + "RED-BLACK TREE");
        System.out.println("═".repeat(70));
        if (root == NIL) {
            System.out.println(" ".repeat(32) + "(kosong)");
        } else {
            printNode(root, "", true);
        }
        System.out.println("═".repeat(70) + "\n");
    }

    private void printNode(Node node, String prefix, boolean isTail) {
        if (node == NIL) return;

        String nodeColor = node.isRed ? "\u001B[31m" : "\u001B[37m";
        String reset = "\u001B[0m";
        String label = nodeColor + node.key + reset;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + label);

        List<Node> children = new ArrayList<>();
        if (node.left != NIL) children.add(node.left);
        if (node.right != NIL) children.add(node.right);

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            String newPrefix = prefix + (isTail ? "    " : "│   ");
            printNode(child, newPrefix, i == children.size() - 1);
        }
    }

    // Traversal
    public void preOrder()  { System.out.print("Pre-order  : "); preOrderRec(root);  System.out.println(); }
    private void preOrderRec(Node node)  { if (node != NIL) { System.out.print(node.key + " "); preOrderRec(node.left); preOrderRec(node.right); } }

    public void inOrder()   { System.out.print("In-order   : "); inOrderRec(root);   System.out.println(); }
    private void inOrderRec(Node node)   { if (node != NIL) { inOrderRec(node.left); System.out.print(node.key + " "); inOrderRec(node.right); } }

    public void postOrder() { System.out.print("Post-order : "); postOrderRec(root); System.out.println(); }
    private void postOrderRec(Node node) { if (node != NIL) { postOrderRec(node.left); postOrderRec(node.right); System.out.print(node.key + " "); } }

    public void printInsertOrder() {
        System.out.print("Urutan insert : ");
        if (insertOrder.isEmpty()) System.out.println("(kosong)");
        else for (int k : insertOrder) System.out.print(k + " ");
        System.out.println();
    }

    public void showAll() {
        printInsertOrder();
        printTree();
        preOrder();
        inOrder();
        postOrder();
        System.out.println("─────────────────────────────────────────────\n");
    }
}