package Tugas_4;

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a key
    void insert(char key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, char key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Remove a key
    void remove(char key) {
        root = removeRec(root, key);
    }

    Node removeRec(Node root, char key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = removeRec(root.left, key);
        else if (key > root.key)
            root.right = removeRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = removeRec(root.right, root.key);
        }
        return root;
    }

    char minValue(Node root) {
        char minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Pre-order traversal
    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In-order traversal
    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Post-order traversal
    void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Visualize the tree with ASCII art and colors (using ANSI escape codes)
    public void visualize() {
        System.out.println("Visualisasi Tree (horizontal, root di kiri, cabang kanan atas dengan /, cabang kiri bawah dengan \\):");
        if (root == null) {
            System.out.println("Tree kosong.");
            return;
        }
        printTree(root, "", true);
        System.out.print("\u001B[0m"); // Reset color at the end
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("\u001B[34mR-----\u001B[0m"); // Blue for right branch
                indent += "      ";
            } else {
                System.out.print("\u001B[31mL-----\u001B[0m"); // Red for left branch
                indent += "|     ";
            }
            System.out.println("\u001B[32m" + node.key + "\u001B[0m"); // Green for node key
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}