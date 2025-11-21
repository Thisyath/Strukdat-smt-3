package Tugas_5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            System.out.println("\n======= RED-BLACK TREE (ANGKA) =======");
            System.out.println("1. Mode Manual");
            System.out.println("2. Otomatis (10 angka random)");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            String p = sc.nextLine().trim();

            if (p.equals("1")) {
                rbt.clear();
                System.out.println("\n>>> MODE MANUAL <<<");

                boolean manual = true;
                while (manual) {
                    System.out.println("\n1. INSERT ANGKA");
                    System.out.println("2. SEARCH ANGKA");
                    System.out.println("3. KEMBALI KE MENU UTAMA");
                    System.out.print("Pilih: ");
                    String sub = sc.nextLine().trim();

                    if (sub.equals("1")) {
                        System.out.println("\n--- INSERT TERUS MENERUS ---");
                        System.out.println("Ketik angka, Enter kosong = kembali\n");

                        while (true) {
                            System.out.print("Masukkan angka: ");
                            String in = sc.nextLine().trim();

                            if (in.isEmpty()) {
                                System.out.println("Kembali ke menu manual...\n");
                                break;
                            }
                            try {
                                int num = Integer.parseInt(in);
                                if (rbt.insert(num)) {
                                    System.out.println("✓ Insert " + num + " berhasil!\n");
                                } else {
                                    System.out.println("! " + num + " sudah ada!\n");
                                }
                                rbt.showAll();
                            } catch (Exception e) {
                                System.out.println("Harus angka!\n");
                            }
                        }
                    }
                    else if (sub.equals("2")) {
                        System.out.print("Cari angka: ");
                        String q = sc.nextLine().trim();
                        try {
                            int num = Integer.parseInt(q);
                            boolean ada = rbt.contains(num);
                            System.out.println(ada ? "✓ '" + num + "' ADA!" : "✗ '" + num + "' TIDAK ADA\n");
                        } catch (Exception e) {
                            System.out.println("Harus angka!\n");
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
                System.out.print("\n10 angka random: ");
                for (int i = 0; i < 10; i++) {
                    int n = rand.nextInt(90) + 10;
                    rbt.insert(n);
                    System.out.print(n + " ");
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