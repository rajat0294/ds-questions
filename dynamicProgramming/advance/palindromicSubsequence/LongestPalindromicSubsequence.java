package advance.palindromicSubsequence;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(longestPalindromic(str));
    }

    public static int longestPalindromic(String str){
        int[][] dp=new int[str.length()][str.length()];
        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }
                else if(g==1){
                    dp[i][j]=(str.charAt(i)==str.charAt(j))?2:1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
