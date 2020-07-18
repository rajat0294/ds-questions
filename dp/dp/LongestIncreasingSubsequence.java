package dp;

import javax.sound.midi.Soundbank;

public class LongestIncreasingSubsequence {

    public static int LISTabulated(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j];
                    }
                }
            }
            dp[i] = dp[i] + 1;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


    public static int LISMemoized(int[] arr, int qb[], int index) {
        if (index == 0) {
            return 1;
        }
        if (qb[index] != 0) {
            return qb[index];
        }

        int max = 0;
        for (int j = 0; j < index; j++) {
            if (arr[j] < arr[index]) {
                int listillj = LISMemoized(arr, qb, j);
                if (max < listillj) {
                    max = listillj;
                }
            }
        }
        qb[index]=max+1;
        return max + 1;
    }

    public static void main(String[] ar) {
        int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int[] qb=new int[arr.length];
        //System.out.println("start calculating");
        int maxSubsequenceLength=0;
        for (int i = 0; i < arr.length; i++) {
             int m=LISMemoized(arr, qb, i);
            if (maxSubsequenceLength <= m) {
                maxSubsequenceLength = m;
            }
        }
        System.out.println(maxSubsequenceLength);
    }
}
