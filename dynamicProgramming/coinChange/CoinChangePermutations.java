package coinChange;

import java.util.Scanner;

public class CoinChangePermutations {

    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int sum = scr.nextInt();
        int permutations = coinChangePermutations(arr, sum);
        System.out.println(permutations);

    }

    public static int coinChangePermutations(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[sum];
    }
}
