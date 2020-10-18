package basic.CountEncoding;

import java.util.Scanner;

public class CountEncoding {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(countEncoding(str));
    }

    public static int countEncoding(String str){
        if(Integer.parseInt(str.charAt(0)+"")==0){
            return 0;
        }
        int[] dp=new int[str.length()];
        dp[0]=1;
        for(int i=1;i<str.length();i++){
            if(Integer.parseInt(str.substring(i-1,i+1))<=26){
                dp[i]=dp[i-1]+1;
            }else{
                if(Integer.parseInt(str.charAt(i)+"")==0){
                    return 0;
                }else {
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[str.length()-1];
    }
}
