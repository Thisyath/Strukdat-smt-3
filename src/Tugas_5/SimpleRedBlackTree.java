package Tugas_5;

public class SimpleRedBlackTree {

    /* ---------- WARNA ---------- */
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    /* ---------- NODE ---------- */
    private static class Node {
        int key;
        Node left, right, parent;
        boolean color;
        Node(int k) { key = k; color = RED; } // baru selalu MERAH
    }

    /* ---------- TREE ---------- */
    private Node root;

    /* ---------- ROTASI KIRI ---------- */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        if (x.left != null) x.left.parent = h;
        x.parent = h.parent;
        if (h.parent == null) root = x;
        else if (h == h.parent.left) h.parent.left = x;
        else h.parent.right = x;
        x.left = h;
        h.parent = x;
        return x;
    }

    /* ---------- ROTASI KANAN ---------- */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        if (x.right != null) x.right.parent = h;
        x.parent = h.parent;
        if (h.parent == null) root = x;
        else if (h == h.parent.left) h.parent.left = x;
        else h.parent.right = x;
        x.right = h;
        h.parent = x;
        return x;
    }

    /* ---------- FLIP WARNA ---------- */
    private void flipColors(Node h) {
        h.color        = RED;
        h.left.color   = BLACK;
        h.right.color  = BLACK;
    }

    private boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    /* ---------- INSERT ---------- */
    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK; // aturan #3
    }

    private Node insert(Node h, int key) {
        if (h == null) return new Node(key);

        if (key < h.key) {
            h.left = insert(h.left, key);
            h.left.parent = h;
        }
        else if (key > h.key) {
            h.right = insert(h.right, key);
            h.right.parent = h;
        }
        else return h; // duplikat diabaikan

        // fix-up
        if (isRed(h.right) && !isRed(h.left))     h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

        return h;
    }

    /* ---------- CETAK IN-ORDER (untuk cek) ---------- */
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    private void printInOrder(Node x) {
        if (x == null) return;
        printInOrder(x.left);
        System.out.print(x.key + (x.color == RED ? "(R) " : "(B) "));
        printInOrder(x.right);
    }

    /* ---------- MAIN (quick test) ---------- */
    public static void main(String[] args) {
        SimpleRedBlackTree rbt = new SimpleRedBlackTree();
        int[] data = {10, 20, 15, 30, 5, 1};
        for (int v : data) rbt.insert(v);
        rbt.printInOrder();  // melihat hasil & warna
    }
}