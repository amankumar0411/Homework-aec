//Problem 2
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTransformationMinCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        long[] arr = new long[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        System.out.print("Enter K: ");
        long k = scanner.nextLong();
        scanner.close();

        long result = minOperationsToEqualize(arr, k);
        System.out.println("Minimum operations: " + result);
    }

    private static long minOperationsToEqualize(long[] arr, long k) {
        int n = arr.length;
        long remainder = arr[0] % k;


        for (int i = 1; i < n; i++) {
            if (arr[i] % k != remainder) {
                return -1;
            }
        }


        long[] quotients = new long[n];
        for (int i = 0; i < n; i++) {
            quotients[i] = (arr[i] - remainder) / k;
        }


        Arrays.sort(quotients);
        long median = quotients[n / 2];


        long totalOps = 0;
        for (long q : quotients) {
            totalOps += Math.abs(q - median);
        }

        return totalOps;
    }
}