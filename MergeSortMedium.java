package week3module;
import java.util.*;

public class MergeSortMedium {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        sort(arr, 0, n - 1);
        for (int x : arr) System.out.print(x + " ");
        System.out.println();

        int median = arr[n / 2];
        int count = 0;
        for (int x : arr) if (x > median) count++;

        System.out.println("Median: " + median);
        System.out.println("Orders Above Median: " + count);
        System.out.println("Difference: " + (arr[n - 1] - arr[0]));
    }

    static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) t[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        while (i <= m) t[k++] = arr[i++];
        while (j <= r) t[k++] = arr[j++];
        for (i = 0; i < t.length; i++) arr[l + i] = t[i];
    }
}