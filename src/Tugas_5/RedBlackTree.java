package Tugas_5;

import java.util.ArrayList;

public class RedBlackTree {
    private Node root;
    private final Node NIL;
    private final ArrayList<Character> insertOrder = new ArrayList<>();

    public RedBlackTree() {
        NIL = new Node('\0');
        NIL.isRed = false;
        NIL.left = NIL.right = NIL.parent = NIL;
        root = NIL;
    }

    public void clear() {
        root = NIL;
        insertOrder.clear();
    }

    public boolean insert(char key) {
        key = Character.toUpperCase(key);
        if (key < 'A' || key > 'Z') return false;

        Node z = new Node(key);
        Node y = NIL;
        Node x = root;

        while (x != NIL) {
            y = x;
            if (z.key < x.key) x = x.left;
            else if (z.key > x.key) x = x.right;
            else return false; // duplikat
        }

        z.parent = y;
        if (y == NIL) root = z;
        else if (z.key < y.key) y.left = z;
        else y.right = z;

        z.left = NIL;
        z.right = NIL;
        insertOrder.add(key);

        fixInsert(z);  // ini yang diperbaiki total
        return true;
    }

    private void fixInsert(Node z) {
        while (z.parent.isRed) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right; // uncle
                if (y.isRed) {
                    // Case 1: uncle merah → recolor
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        // Case 2: uncle hitam, z anak kanan → rotate left
                        z = z.parent;
                        leftRotate(z);
                    }
                    // Case 3: uncle hitam, z anak kiri → recolor + right rotate
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    rightRotate(z.parent.parent);
                }
            } else { // symmetric: parent adalah anak kanan grandparent
                Node y = z.parent.parent.left; // uncle
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
        root.isRed = false; // root selalu hitam
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

    public boolean contains(char key) {
        key = Character.toUpperCase(key);
        Node current = root;
        while (current != NIL) {
            if (key == current.key) return true;
            current = key < current.key ? current.left : current.right;
        }
        return false;
    }

    public void printTree() {
        System.out.println("\n════════════════ RED-BLACK TREE ════════════════");
        if (root == NIL) {
            System.out.println("                   (kosong)");
        } else {
            printClassic(root, 0);
        }
        System.out.println("════════════════════════════════════════════════\n");
    }

    private void printClassic(Node node, int depth) {
        if (node == NIL) return;

        printClassic(node.right, depth + 1);

        for (int i = 0; i < depth; i++) System.out.print("     ");

        if (node == root) System.out.print("\u001B[1m"); // bold root
        String color = node.isRed ? "\u001B[31m" : "\u001B[37m";
        System.out.println(color + node.key + " (" + (node.isRed ? "R" : "B") + ")\u001B[0m");

        printClassic(node.left, depth + 1);
    }

    public void preOrder()  { System.out.print("Pre-order  : "); preOrderRec(root);  System.out.println(); }
    private void preOrderRec(Node node)  { if (node != NIL) { System.out.print(node.key + " "); preOrderRec(node.left); preOrderRec(node.right); } }

    public void inOrder()   { System.out.print("In-order   : "); inOrderRec(root);   System.out.println(); }
    private void inOrderRec(Node node)   { if (node != NIL) { inOrderRec(node.left); System.out.print(node.key + " "); inOrderRec(node.right); } }

    public void postOrder() { System.out.print("Post-order : "); postOrderRec(root); System.out.println(); }
    private void postOrderRec(Node node) { if (node != NIL) { postOrderRec(node.left); postOrderRec(node.right); System.out.print(node.key + " "); } }

    public void printInsertOrder() {
        System.out.print("Urutan insert : ");
        if (insertOrder.isEmpty()) System.out.println("(kosong)");
        else for (char c : insertOrder) System.out.print(c + " ");
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