package week3module;
import java.util.*;
public class QuickSortMedium {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            totalSum += arr[i];
        }

        quickSortDesc(arr, 0, n - 1);
        for (long x : arr) System.out.print(x + " ");
        System.out.println();

        System.out.print("Top 5:");
        long top5Sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print(" " + arr[i]);
            top5Sum += arr[i];
        }
        System.out.println();

        System.out.println("Average of Top 5: " + (top5Sum / 5));
        
        double overallAvg = (double) totalSum / n;
        int count = 0;
        for (long x : arr) if (x > overallAvg) count++;
        System.out.println("Values Above Overall Average: " + count);
    }

    static void quickSortDesc(long[] arr, int low, int high) {
        if (low >= high) return;
        int pi = partitionDesc(arr, low, high);
        quickSortDesc(arr, low, pi - 1);
        quickSortDesc(arr, pi + 1, high);
    }

    static int partitionDesc(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) { // '>' makes it sort descending
                i++;
                long temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        long temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}