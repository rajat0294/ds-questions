package basic.CountBinaryString;

import java.util.Scanner;

public class CountBinaryString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(countBinaryString(n));
    }

    public static  int countBinaryString(int n){
        int[][] dp=new int[n][2];
        dp[0][0]=1;
        dp[0][1]=1;
        for(int i=1;i<dp.length;i++){
            dp[i][0]=dp[i-1][1];
            dp[i][1]=dp[i-1][1]+dp[i-1][0];
        }
        return dp[n-1][0]+dp[n-1][1];
    }
}
