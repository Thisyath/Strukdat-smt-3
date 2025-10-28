package Tugas_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert data (huruf)");
            System.out.println("2. Remove data (huruf)");
            System.out.println("3. Generate 10 huruf random dan insert");
            System.out.println("4. Tampilkan Traversals (Pre-order, In-order, Post-order)");
            System.out.println("5. Visualisasi Tree");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan huruf untuk insert: ");
                    char insertKey = scanner.nextLine().charAt(0);
                    tree.insert(insertKey);
                    System.out.println("Huruf '" + insertKey + "' telah diinsert.");
                    break;
                case 2:
                    System.out.print("Masukkan huruf untuk remove: ");
                    char removeKey = scanner.nextLine().charAt(0);
                    tree.remove(removeKey);
                    System.out.println("Huruf '" + removeKey + "' telah diremove jika ada.");
                    break;
                case 3:
                    System.out.println("Generate dan insert 10 huruf random (A-Z):");
                    for (int i = 0; i < 10; i++) {
                        char randomChar = (char) (rand.nextInt(26) + 'A');
                        System.out.print(randomChar + " ");
                        tree.insert(randomChar);
                    }
                    System.out.println("\n10 huruf random telah diinsert.");
                    break;
                case 4:
                    System.out.println("Pre-order traversal:");
                    tree.preOrder();
                    System.out.println("\nIn-order traversal:");
                    tree.inOrder();
                    System.out.println("\nPost-order traversal:");
                    tree.postOrder();
                    System.out.println();
                    break;
                case 5:
                    tree.visualize();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
        scanner.close();
    }
}