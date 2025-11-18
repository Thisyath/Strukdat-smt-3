package AVLTree_khusus;

import java.util.ArrayList;

public class AVLTree {
    private Node root;
    private final ArrayList<Character> insertOrder = new ArrayList<>();

    public void clear() {
        root = null;
        insertOrder.clear();
    }

    public boolean insert(char key) {
        key = Character.toUpperCase(key);
        if (key < 'A' || key > 'Z') return false;

        if (contains(key)) return false;

        root = insertRec(root, key);
        insertOrder.add(key);
        return true;
    }

    private Node insertRec(Node node, char key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insertRec(node.left, key);
        else if (key > node.key)
            node.right = insertRec(node.right, key);
        else
            return node; // duplikat tidak diizinkan

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Heavy
        if (balance > 1) {
            if (key < node.left.key)  return rightRotate(node);     // LL
            else {                          // LR
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (key > node.right.key) return leftRotate(node);      // RR
            else {                          // RL
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private int height(Node n) { return n == null ? 0 : n.height; }
    private int getBalance(Node n) { return n == null ? 0 : height(n.left) - height(n.right); }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public boolean contains(char key) {
        key = Character.toUpperCase(key);
        return containsRec(root, key);
    }

    private boolean containsRec(Node node, char key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? containsRec(node.left, key) : containsRec(node.right, key);
    }

    public void printTree() {
        System.out.println("\n══════════════════ AVL TREE ══════════════════");
        if (root == null) {
            System.out.println("                   (kosong)");
        } else {
            printClassic(root, 0);
        }
        System.out.println("═══════════════════════════════════════════════\n");
    }

    private void printClassic(Node node, int depth) {
        if (node == null) return;

        printClassic(node.right, depth + 1);

        for (int i = 0; i < depth; i++) System.out.print("     ");

        if (node == root) System.out.print("\u001B[1m"); // bold untuk root
        System.out.println("\u001B[37m" + node.key + "\u001B[0m");

        printClassic(node.left, depth + 1);
    }

    public void preOrder()  { System.out.print("Pre-order  : "); preOrderRec(root);  System.out.println(); }
    private void preOrderRec(Node node)  { if (node != null) { System.out.print(node.key + " "); preOrderRec(node.left); preOrderRec(node.right); } }

    public void inOrder()   { System.out.print("In-order   : "); inOrderRec(root);   System.out.println(); }
    private void inOrderRec(Node node)   { if (node != null) { inOrderRec(node.left); System.out.print(node.key + " "); inOrderRec(node.right); } }

    public void postOrder() { System.out.print("Post-order : "); postOrderRec(root); System.out.println(); }
    private void postOrderRec(Node node) { if (node != null) { postOrderRec(node.left); postOrderRec(node.right); System.out.print(node.key + " "); } }

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