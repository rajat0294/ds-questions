package advance.lis;

import java.util.Scanner;

public class LIS {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println(longestIncreasingSubsequenceCount(n, arr));
    }

    private static int longestIncreasingSubsequenceCount(int n, int[] arr) {
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j] && (dp[j]+1)>max){
                    max=dp[j]+1;
                }
            }
            dp[i]=max;
        }
        int max=Integer.MIN_VALUE;

        for(int k=0;k<n;k++){

            if(dp[k]>max){
                max=dp[k];
            }
        }
        return max;
    }
}
