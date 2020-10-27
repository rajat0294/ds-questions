package advance.lis;

import java.util.Scanner;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println(longestBitonicSubsequenceCount(arr));
    }

    private static int longestBitonicSubsequenceCount(int[] arr) {
        int[] dp1=new int[arr.length];
        int[] dp2=new int[arr.length];


        for(int i=0;i<arr.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j] && dp1[j]+1>max){
                    max=dp1[j]+1;
                }
            }
        }

        for(int i=arr.length-1;i>=0;i--){
            int max=1;
            for(int j=arr.length-1;j>i;j--){
                if(arr[i]>=arr[j] && dp2[j]+1>max){
                    max=dp2[j]+1;
                }
            }
        }
        int max=1;
        for(int k=0;k<arr.length;k++){
            max=Math.max(dp1[k]+dp2[k]-1,max);
        }
        return max;
    }


}
