package Tugas_3;

import java.util.Arrays;

public class Quick {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Setelah partition (pivot di " + pi + "): " + Arrays.toString(arr));
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        System.out.println("Pivot: " + pivot + " (indeks " + high + ")");
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                System.out.println("Swap: " + arr[i] + " dengan " + arr[j] + " (indeks " + i + " dan " + j + ")");
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("Array sementara: " + Arrays.toString(arr));
            }
        }
        System.out.println("Swap pivot: " + arr[i + 1] + " dengan " + arr[high] + " (indeks " + (i + 1) + " dan " + high + ")");
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println("Array setelah swap pivot: " + Arrays.toString(arr));
        return i + 1;
    }
}
