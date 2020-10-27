package advance.palindromicSubstring;

import java.util.Scanner;

public class CountPalindromicSubstring {
    private static int countPalindromicSubstring(String str){
        boolean dp[][]=new boolean[str.length()][str.length()];
        int count=0;
        for(int g=0;g<str.length();g++){
            for(int i=0,j=g;j<str.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    dp[i][j]=(str.charAt(i)==str.charAt(j))?true:false;
                }else{
                    dp[i][j]=(str.charAt(i)==str.charAt(j)&& dp[i+1][j-1])?true:false;
                }
               if(dp[i][j]){
                   count++;
               }
            }
        }
       return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(countPalindromicSubstring(str));
    }
}
