package basic.tillingProblem;

import java.util.Scanner;

public class TwoCrossOneTillingProblem {

    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        System.out.println(dp[n-1]);
    }
}
