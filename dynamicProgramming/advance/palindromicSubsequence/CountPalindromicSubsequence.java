package advance.palindromicSubsequence;
import java.io.*;
import java.util.*;

public class CountPalindromicSubsequence {

        public static int solution(String str) {
            // write your code here
            int[][] dp=new int[str.length()][str.length()];
            for(int g=0;g<str.length();g++){
                for(int i=0,j=g;j<str.length();i++,j++){
                    if(g==0){
                        dp[i][j]=1;
                    }else if(g==1){
                        dp[i][j]=(str.charAt(i)==str.charAt(j))?3:2;
                    }else{
                        if(str.charAt(i)==str.charAt(j)){
                            dp[i][j]=dp[i+1][j-1]+1;
                        }else{
                            dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                        }
                    }
                }
            }
            return dp[0][str.length()-1];
        }
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            System.out.println(solution(str));
        }

    }
