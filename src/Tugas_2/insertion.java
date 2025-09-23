package Tugas_2;

/**
 * Implementasi algoritma Insertion Sort
 * Konsep: Menyisipkan setiap elemen ke posisi yang tepat dalam bagian terurut
 * Time Complexity: O(n²) worst case, O(n) best case
 */
public class insertion {

    public void sort(int[] arr) {
        int n = arr.length;

        // Mulai dari elemen kedua (indeks 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Elemen yang akan disisipkan
            int j = i - 1;     // Indeks elemen terakhir dari bagian terurut

            // Geser elemen-elemen yang lebih besar dari key ke kanan
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Sisipkan key pada posisi yang tepat
            arr[j + 1] = key;
        }
    }

    /**
     * Method untuk menampilkan proses sorting (untuk debugging)
     */
    public void sortWithProcess(int[] arr) {
        int n = arr.length;
        System.out.println("INSERTION SORT PROCESS:");
        printArray(arr, "Initial");

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Step " + i + ": Inserting " + key);

            // Geser elemen yang lebih besar
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Sisipkan key
            arr[j + 1] = key;

            printArray(arr, "After step " + i);
        }
    }

    /**
     * Versi optimasi untuk data yang hampir terurut
     */
    public void sortOptimized(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];

            // Jika elemen sudah pada posisi yang tepat, skip
            if (key >= arr[i - 1]) {
                continue;
            }

            // Binary search untuk mencari posisi yang tepat
            int pos = binarySearchPosition(arr, 0, i - 1, key);

            // Geser elemen-elemen
            for (int j = i - 1; j >= pos; j--) {
                arr[j + 1] = arr[j];
            }

            // Sisipkan key
            arr[pos] = key;
        }
    }

    private int binarySearchPosition(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private void printArray(int[] arr, String phase) {
        System.out.print(phase + ": ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
