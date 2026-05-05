//Problem 1
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CyclicSubstringMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = scanner.nextLine().trim();
        scanner.close();

        int result = findMaxCyclicSubstringSum(s);
        System.out.println("Maximum sum: " + result);
    }

    private static int findMaxCyclicSubstringSum(String s) {
        int n = s.length();
        int maxSum = 0;

        for (int start = 0; start < n; start++) {
            Set<Character> seen = new HashSet<>();
            int currentSum = 0;

            for (int offset = 0; offset < 26; offset++) {
                char ch = s.charAt((start + offset) % n);
                if (seen.contains(ch)) {
                    break;
                }
                seen.add(ch);
                currentSum += (ch - 'a' + 1);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}