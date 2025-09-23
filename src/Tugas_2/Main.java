package Tugas_2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PROGRAM PERBANDINGAN ALGORITMA SORTING ===\n");

        // 1. Siapkan 10 deret bilangan acak
        System.out.println("1. MENYIAPKAN 10 BILANGAN ACAK");
        int[] originalData = generateRandomArray(10);
        System.out.println("Data asli: " + Arrays.toString(originalData));
        System.out.println();

        // 2. Test Bubble Sort
        testBubbleSort(originalData.clone());

        // 3. Test Selection Sort
        testSelectionSort(originalData.clone());

        // 4. Test Insertion Sort
        testInsertionSort(originalData.clone());

        // 5 & 6. Perbandingan performa dengan 100,000 data
        comparePerformance();
    }

    private static void testBubbleSort(int[] data) {
        System.out.println("2. BUBBLE SORT");
        System.out.println("Data sebelum: " + Arrays.toString(data));

        long startTime = System.nanoTime();
        bubble bubbleSort = new bubble();
        bubbleSort.sort(data);
        long endTime = System.nanoTime();

        System.out.println("Data sesudah: " + Arrays.toString(data));
        System.out.println("Waktu eksekusi: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Status: " + (isSorted(data) ? "BERHASIL TERURUT" : "GAGAL"));
        System.out.println();
    }

    private static void testSelectionSort(int[] data) {
        System.out.println("3. SELECTION SORT");
        System.out.println("Data sebelum: " + Arrays.toString(data));

        long startTime = System.nanoTime();
        selection selectionSort = new selection();
        selectionSort.sort(data);
        long endTime = System.nanoTime();

        System.out.println("Data sesudah: " + Arrays.toString(data));
        System.out.println("Waktu eksekusi: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Status: " + (isSorted(data) ? "BERHASIL TERURUT" : "GAGAL"));
        System.out.println();
    }

    private static void testInsertionSort(int[] data) {
        System.out.println("4. INSERTION SORT");
        System.out.println("Data sebelum: " + Arrays.toString(data));

        long startTime = System.nanoTime();
        insertion insertionSort = new insertion();
        insertionSort.sort(data);
        long endTime = System.nanoTime();

        System.out.println("Data sesudah: " + Arrays.toString(data));
        System.out.println("Waktu eksekusi: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Status: " + (isSorted(data) ? "BERHASIL TERURUT" : "GAGAL"));
        System.out.println();
    }

    private static void comparePerformance() {
        System.out.println("5. GENERATE 100,000 BILANGAN ACAK");
        int[] largeData = generateRandomArray(100000);
        System.out.println("Data 100,000 bilangan acak telah digenerate");
        System.out.println();

        System.out.println("6. PERBANDINGAN KECEPATAN ALGORITMA (100,000 data)");
        System.out.println("=" .repeat(60));

        // Test Bubble Sort
        int[] bubbleData = largeData.clone();
        long startTime = System.currentTimeMillis();
        bubble bubbleSort = new bubble();
        bubbleSort.sort(bubbleData);
        long bubbleTime = System.currentTimeMillis() - startTime;

        // Test Selection Sort
        int[] selectionData = largeData.clone();
        startTime = System.currentTimeMillis();
        selection selectionSort = new selection();
        selectionSort.sort(selectionData);
        long selectionTime = System.currentTimeMillis() - startTime;

        // Test Insertion Sort
        int[] insertionData = largeData.clone();
        startTime = System.currentTimeMillis();
        insertion insertionSort = new insertion();
        insertionSort.sort(insertionData);
        long insertionTime = System.currentTimeMillis() - startTime;

        // Hasil perbandingan
        System.out.println("HASIL PERBANDINGAN:");
        System.out.println("1. Bubble Sort    : " + bubbleTime + " ms");
        System.out.println("2. Selection Sort : " + selectionTime + " ms");
        System.out.println("3. Insertion Sort : " + insertionTime + " ms");

        // Menentukan yang tercepat
        String fastest = "Insertion Sort";
        long fastestTime = insertionTime;

        if (bubbleTime < fastestTime) {
            fastest = "Bubble Sort";
            fastestTime = bubbleTime;
        }
        if (selectionTime < fastestTime) {
            fastest = "Selection Sort";
            fastestTime = selectionTime;
        }

        System.out.println("\nALGORITMA TERCEPAT: " + fastest + " (" + fastestTime + " ms)");

        // Verifikasi semua berhasil terurut
        System.out.println("\nVERIFIKASI HASIL:");
        System.out.println("Bubble Sort terurut: " + isSorted(bubbleData));
        System.out.println("Selection Sort terurut: " + isSorted(selectionData));
        System.out.println("Insertion Sort terurut: " + isSorted(insertionData));
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Random 0-999
        }
        return array;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }
}
