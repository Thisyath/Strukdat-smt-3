package Tugas_3;

import java.util.Arrays;

public class Quick {
    public static void quickSort(int[] arr, int low, int high, boolean verbose) {
        if (low < high) {
            int pi = partition(arr, low, high, verbose);
            if (verbose) System.out.println("Setelah partition (pivot di " + pi + "): " + Arrays.toString(arr));
            quickSort(arr, low, pi - 1, verbose);
            quickSort(arr, pi + 1, high, verbose);
        }
    }

    private static int partition(int[] arr, int low, int high, boolean verbose) {
        int pivot = arr[high];
        if (verbose) System.out.println("Pivot: " + pivot + " (indeks " + high + ")");
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                if (verbose) System.out.println("Swap: " + arr[i] + " dengan " + arr[j] + " (indeks " + i + " dan " + j + ")");
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (verbose) System.out.println("Array sementara: " + Arrays.toString(arr));
            }
        }
        if (verbose) System.out.println("Swap pivot: " + arr[i + 1] + " dengan " + arr[high] + " (indeks " + (i + 1) + " dan " + high + ")");
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        if (verbose) System.out.println("Array setelah swap pivot: " + Arrays.toString(arr));
        return i + 1;
    }
}