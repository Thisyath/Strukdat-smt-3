package Tugas_3;

import java.util.Arrays;

public class Merge {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        System.out.println("Split menjadi left: " + Arrays.toString(left) + " dan right: " + Arrays.toString(right));

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        System.out.println("Merging left: " + Arrays.toString(left) + " dan right: " + Arrays.toString(right));
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
                System.out.println("Ambil dari left: " + left[i-1]);
            } else {
                arr[k++] = right[j++];
                System.out.println("Ambil dari right: " + right[j-1]);
            }
            System.out.println("Array merging sementara: " + Arrays.toString(arr));
        }
        while (i < left.length) {
            arr[k++] = left[i++];
            System.out.println("Ambil sisa left: " + left[i-1]);
            System.out.println("Array merging sementara: " + Arrays.toString(arr));
        }
        while (j < right.length) {
            arr[k++] = right[j++];
            System.out.println("Ambil sisa right: " + right[j-1]);
            System.out.println("Array merging sementara: " + Arrays.toString(arr));
        }
        System.out.println("Hasil merge: " + Arrays.toString(arr));
    }
}
