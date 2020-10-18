package basic.tillingProblem;

import java.util.Scanner;

public class McrossOneTillingProblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }else if(i==m){
                dp[i]=2;
            }
            else {
                dp[i]=dp[i-1]+dp[i-m];
            }
        }
    }
}
