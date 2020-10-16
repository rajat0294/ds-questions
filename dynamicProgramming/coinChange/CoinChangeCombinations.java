package coinChange;

import java.util.Scanner;

public class CoinChangeCombinations {

    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }

        int sum = scr.nextInt();
        int combinations = coinChangeCombinations(arr, sum);
        System.out.println(combinations);

    }

    public static int coinChangeCombinations(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i <coins.length; i++) {
            for (int j = coins[i]; j <=sum; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[sum];
    }
}
