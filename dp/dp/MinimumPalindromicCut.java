package dp;

import java.util.HashMap;

public class MinimumPalindromicCut {
    public static void main(String[] args) {
        System.out.println(minimunPalindromicCutRecursion("abccbc".toCharArray(),0,5));
    }

    public static int minimumPalindromicCut(char[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 0;
        boolean palindromic = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                palindromic = true;
                if (arr[i] == arr[j] && isPalindrom(arr, i, j)) {
                    if (dp[i] > dp[j]) {
                        dp[i] = dp[j];
                        break;
                    }
                }
            }
            if (palindromic) {
                dp[i] = dp[i];
            } else if (arr[i - 1] != arr[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }

        }
        return dp[arr.length - 1];
    }

    public static boolean isPalindrom(char[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return true;
        }
        if (arr[startIndex] == arr[endIndex]) {
            if (startIndex <= endIndex) {
                return isPalindrom(arr, startIndex + 1, endIndex - 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static int minimunPalindromicCutRecursion(char[] arr, int startIndex, int endIndex) {
        int min = Integer.MAX_VALUE;
        if(isPalindrom(arr,startIndex,endIndex)){
            return 0;
        }
        for (int i = startIndex; i < endIndex; i++) {
            int cost = minimunPalindromicCutRecursion(arr, startIndex, i) + minimunPalindromicCutRecursion(arr, i + 1, endIndex)+1;
            if (cost < min) {
                min = cost;
            }
        }
        return min;
    }

    public static int minimunPalindromicCutMemoized(char[] arr, int startIndex, int endIndex, HashMap<String,Integer> qb) {
        int min = Integer.MAX_VALUE;
        if(isPalindrom(arr,startIndex,endIndex)){
            return 0;
        }
        if(qb.get(startIndex+"-"+endIndex)!=null){
            return qb.get(startIndex+"-"+endIndex);
        }
        for (int i = startIndex; i < endIndex; i++) {
            int cost = minimunPalindromicCutMemoized(arr, startIndex, i,qb) + minimunPalindromicCutMemoized(arr, i + 1, endIndex,qb)+1;
            if (cost < min) {
                min = cost;
            }
        }
        qb.put(startIndex+"-"+endIndex,min);
        return min;
    }

}
