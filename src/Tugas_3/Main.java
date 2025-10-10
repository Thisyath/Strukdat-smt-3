package Tugas_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        System.out.print("Masukkan ukuran array untuk pengujian individu (default 10): ");
        int smallSize = scanner.hasNextInt() ? scanner.nextInt() : 10;
        int[] originalSmall = new int[smallSize];
        for (int i = 0; i < smallSize; i++) {
            originalSmall[i] = rand.nextInt(100); // Random 0-99
        }
        System.out.println("Array random awal untuk pengujian individu: " + Arrays.toString(originalSmall));

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Jalankan Shell Sort");
            System.out.println("2. Jalankan Merge Sort");
            System.out.println("3. Jalankan Quick Sort");
            System.out.println("4. Bandingkan Kecepatan Semua Algoritma");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] arr1 = Arrays.copyOf(originalSmall, smallSize);
                    runSort("Shell Sort", arr1, (arr, verbose) -> Shell.shellSort(arr, verbose));
                    break;
                case 2:
                    int[] arr2 = Arrays.copyOf(originalSmall, smallSize);
                    runSort("Merge Sort", arr2, (arr, verbose) -> Merge.mergeSort(arr, verbose));
                    break;
                case 3:
                    int[] arr3 = Arrays.copyOf(originalSmall, smallSize);
                    runSort("Quick Sort", arr3, (arr, verbose) -> Quick.quickSort(arr, 0, arr.length - 1, verbose));
                    break;
                case 4:
                    compareAll();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
        scanner.close();
    }

    @FunctionalInterface
    interface Sorter {
        void sort(int[] arr, boolean verbose);
    }

    private static void runSort(String name, int[] arr, Sorter sorter) {
        System.out.println("\n" + name + ":");
        System.out.println("Sebelum: " + Arrays.toString(arr));
        sorter.sort(arr, true);
        System.out.println("Sesudah: " + Arrays.toString(arr));
    }

    private static void compareAll() {
        int size = 1000; // Ukuran array besar untuk pengukuran waktu
        Random rand = new Random();
        int[] original = new int[size];
        for (int i = 0; i < size; i++) {
            original[i] = rand.nextInt(100000);
        }
        System.out.println("\nArray random awal untuk perbandingan (ukuran " + size + ", ditampilkan sebagian): " + Arrays.toString(Arrays.copyOf(original, 20)) + "...");

        // Shell Sort
        int[] arr1 = Arrays.copyOf(original, size);
        long start = System.nanoTime();
        Shell.shellSort(arr1, false);
        long end = System.nanoTime();
        System.out.println("\nWaktu Shell Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Merge Sort
        int[] arr2 = Arrays.copyOf(original, size);
        start = System.nanoTime();
        Merge.mergeSort(arr2, false);
        end = System.nanoTime();
        System.out.println("Waktu Merge Sort: " + (end - start) / 1_000_000.0 + " ms");

        // Quick Sort
        int[] arr3 = Arrays.copyOf(original, size);
        start = System.nanoTime();
        Quick.quickSort(arr3, 0, size - 1, false);
        end = System.nanoTime();
        System.out.println("Waktu Quick Sort: " + (end - start) / 1_000_000.0 + " ms");
    }
}