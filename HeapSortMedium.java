package week3module;

import java.util.*;

public class HeapSortMedium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        heapSort(arr);
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        double avg = sum / n;
        int count = 0;
        for (int x : arr) if (x < avg) count++;

        System.out.println("Fastest: " + arr[0]);
        System.out.println("Slowest: " + arr[n - 1]);
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Cases Faster Than Average: " + count);
        System.out.printf("Percentage: %.2f%%\n", ((double) count / n) * 100);
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i]; arr[i] = arr[largest]; arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}