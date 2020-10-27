package advance.palindromicSubstring;

import java.util.Scanner;

public class LongestPalindromicSubstring {

    private static int longestPalindromicSubstring(String str){
        int dp[][]=new int[str.length()][str.length()];

        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<str.length();i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    dp[i][j]=(str.charAt(i)==str.charAt(j))?2:1;
                }else{
                    dp[i][j]=(str.charAt(i)==str.charAt(j))? dp[i+1][j-1]+2 :dp[i+1][j-1];
                }
            }
        }
        int max=0;
         for(int i=0;i<str.length()-1;i++){
             max=Math.max(max,dp[i][str.length()-1]);
         }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(longestPalindromicSubstring(str));
    }
}
