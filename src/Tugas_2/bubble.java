package Tugas_2;

/**
 * Implementasi algoritma Bubble Sort
 * Konsep: Membandingkan elemen bersebelahan dan menukar jika tidak urut
 * Time Complexity: O(n²)
 */
public class bubble {

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop untuk setiap pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop untuk membandingkan elemen bersebelahan
            for (int j = 0; j < n - i - 1; j++) {
                // Jika elemen kiri lebih besar dari kanan, tukar
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // Jika tidak ada pertukaran, array sudah terurut
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Method untuk menukar dua elemen dalam array
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Method untuk menampilkan proses sorting (untuk debugging)
     */
    public void sortWithProcess(int[] arr) {
        int n = arr.length;
        System.out.println("BUBBLE SORT PROCESS:");
        printArray(arr, "Initial");

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            printArray(arr, "Pass " + (i + 1));

            if (!swapped) {
                System.out.println("No swaps needed. Array is sorted!");
                break;
            }
        }
    }

    private void printArray(int[] arr, String phase) {
        System.out.print(phase + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}