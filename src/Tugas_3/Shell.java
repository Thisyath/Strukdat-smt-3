package Tugas_3;

import java.util.Arrays;

public class Shell {
    public static void shellSort(int[] arr, boolean verbose) {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            if (verbose) System.out.println("Gap: " + gap);
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    if (verbose) System.out.println("Swap: " + arr[j - gap] + " dengan " + arr[j]);
                    arr[j] = arr[j - gap];
                    if (verbose) System.out.println("Array sementara: " + Arrays.toString(arr));
                }
                arr[j] = temp;
                if (verbose && j != i) {
                    System.out.println("Insert " + temp + " ke posisi " + j);
                    System.out.println("Array setelah insert: " + Arrays.toString(arr));
                }
            }
        }
    }
}