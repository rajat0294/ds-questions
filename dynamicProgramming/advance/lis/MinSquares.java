package advance.lis;

import java.util.Scanner;

public class MinSquares {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(i-(j*j)>=0 && dp[i-(j*j)]+1<min){
                    min=dp[i-(j*j)]+1;
                }
            }
            dp[i]=min;
        }
        System.out.println(dp[n]);
    }

}
