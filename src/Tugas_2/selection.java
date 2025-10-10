package Tugas_2;

public class selection {

    public void sort(int[] arr) {
        int n = arr.length;

        // Outer loop untuk setiap posisi
        for (int i = 0; i < n - 1; i++) {
            // Cari indeks elemen minimum dari sisa array
            int minIndex = findMinIndex(arr, i, n - 1);

            // Tukar elemen minimum dengan elemen di posisi i
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * Method untuk mencari indeks elemen minimum dalam range tertentu
     */
    private int findMinIndex(int[] arr, int start, int end) {
        int minIndex = start;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
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
        System.out.println("SELECTION SORT PROCESS:");
        printArray(arr, "Initial");

        for (int i = 0; i < n - 1; i++) {
            int minIndex = findMinIndex(arr, i, n - 1);

            System.out.println("Step " + (i + 1) + ": Min element " +
                    arr[minIndex] + " at index " + minIndex);

            if (minIndex != i) {
                swap(arr, i, minIndex);
                System.out.println("Swapped " + arr[minIndex] +
                        " and " + arr[i]);
            }

            printArray(arr, "After step " + (i + 1));
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