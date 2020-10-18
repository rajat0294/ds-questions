package basic.nonadjacentmaxSum;

import java.util.Scanner;

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(maxNonAdjacentSum(arr));
    }

    public static int maxNonAdjacentSum(int[] arr){
        int[] dp=new int[arr.length];
        if(arr.length==1){
            return arr[0];
        }

        if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }

        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[arr.length-1];
    }
}
