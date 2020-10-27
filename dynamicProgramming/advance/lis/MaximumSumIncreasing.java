package advance.lis;

import java.util.Scanner;

public class MaximumSumIncreasing {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        int dp[]=new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int max=arr[i];
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[j]+arr[i]> max ){
                    max=dp[j]+arr[i];
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
        System.out.println(max);
    }
}
