package Tugas_5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            System.out.println("\n======= RED-BLACK TREE (A-Z) =======");
            System.out.println("1. Insert Manual");
            System.out.println("2. Generate 10 Huruf Otomatis");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            String p = sc.nextLine().trim();

            if (p.equals("1")) {
                rbt.clear();
                System.out.println("\n>>> MODE MANUAL <<<");

                boolean manual = true;
                while (manual) {
                    System.out.println("\n1. Insert Huruf");
                    System.out.println("2. Search Huruf");
                    System.out.println("3. Kembali ke Menu Utama");
                    System.out.print("Pilih: ");
                    String sub = sc.nextLine().trim();

                    if (sub.equals("1")) {
                        System.out.println("\n--- INSERT TERUS MENERUS ---");
                        System.out.println("Ketik huruf satu per satu, Enter kosong = kembali\n");

                        while (true) {
                            System.out.print("Masukkan huruf: ");
                            String in = sc.nextLine().trim().toUpperCase();

                            if (in.isEmpty()) {
                                System.out.println("Kembali ke menu manual...\n");
                                break;
                            }
                            if (in.length() != 1 || in.charAt(0) < 'A' || in.charAt(0) > 'Z') {
                                System.out.println("Harus 1 huruf A-Z!\n");
                                continue;
                            }

                            char h = in.charAt(0);
                            if (rbt.insert(h)) {
                                System.out.println("✓ Insert " + h + " berhasil!\n");
                            } else {
                                System.out.println("! " + h + " sudah ada!\n");
                            }
                            rbt.showAll();
                        }
                    }
                    else if (sub.equals("2")) {
                        System.out.print("Cari huruf: ");
                        String q = sc.nextLine().trim().toUpperCase();
                        if (q.length() == 1 && q.charAt(0) >= 'A' && q.charAt(0) <= 'Z') {
                            boolean ada = rbt.contains(q.charAt(0));
                            System.out.println(ada ? "✓ '" + q.charAt(0) + "' ADA!" : "✗ '" + q.charAt(0) + "' TIDAK ADA\n");
                        } else {
                            System.out.println("Harus 1 huruf A-Z!\n");
                        }
                        rbt.showAll();
                    }
                    else if (sub.equals("3")) {
                        System.out.println("Kembali ke menu utama...\n");
                        manual = false;
                    }
                }
            }
            else if (p.equals("2")) {
                rbt.clear();
                System.out.print("\n10 huruf random: ");
                for (int i = 0; i < 10; i++) {
                    char c = (char)(rand.nextInt(26) + 'A');
                    rbt.insert(c);
                    System.out.print(c + " ");
                }
                System.out.println("\n");
                rbt.showAll();
            }
            else if (p.equals("3")) {
                System.out.println("Terima kasih!");
                break;
            }
        }
        sc.close();
    }
}