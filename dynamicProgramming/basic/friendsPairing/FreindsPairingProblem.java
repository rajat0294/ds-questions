package basic.friendsPairing;

import java.util.Scanner;

public class FreindsPairingProblem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(friendsPairing(n));
    }

    private static int friendsPairing(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }

}
