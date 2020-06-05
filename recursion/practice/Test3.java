package practice;

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args)
    {
        //code
        Scanner scanner = new Scanner(System.in);
        int testCases=Integer.parseInt(scanner.next());
        for(int i=0;i<testCases;i++){
            int n=Integer.parseInt(scanner.next());

            int[][] numArray=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    numArray[j][k]=scanner.nextInt();
                }
            }
            if(isPathPossible(n,numArray)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }

    public static boolean isPathPossible(int n,int[][] arr){
        boolean[][] dp=new boolean[n][n];
        if(arr[n-1][n-1]%2!=0){
            return false;
        }else{
            dp[n-1][n-1]=true;
            arr[0][0]=0;
            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i+1<=n-1 && j+1<=n-1 && (dp[i+1][j] || dp[i][j+1])) {
                        dp[i][j]=(arr[i][j]%2==0)?true:false;
                    }
                    else if(i+1<=n-1 && dp[i+1][j]){
                        dp[i][j]=(arr[i][j]%2==0)?true:false;
                    }
                    else if(j+1<=n-1 && dp[i][j+1]) {
                        dp[i][j]=(arr[i][j]%2==0)?true:false;
                    }
                    else{
                        if(n-1==i && n-1==j){
                            dp[i][j]=true;
                        }else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
            return dp[0][0];
        }
    }
}

