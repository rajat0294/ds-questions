package basic.buyAndSellstocks;

import java.util.Scanner;

public class BuyAndSellWithTwoTransactionsAllowed {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
       //calculate max profit if sold today
        int lsf=arr[0];
        int[] dp1=new int[n];
        int mpist=0;
        for(int i=1;i<n;i++){
            if(arr[i]<lsf){
                lsf=arr[i];
            }
            mpist=(arr[i]-lsf);
            if(mpist>dp1[i-1]){
                dp1[i]=mpist;
            }else{
                dp1[i]=dp1[i-1];
            }
        }
        //calculate max profit if bought today
        int max=arr[arr.length-1];
        int[] dp2=new int[n];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
            }
            if(max-arr[i]>dp2[i+1]){
                dp2[i]=max-arr[i];
            }else{
                dp2[i]=dp2[i+1];
            }
        }

        int op=0;
        for(int i=0;i<n;i++){
            if(op<dp1[i]+dp2[i]){
                op=dp1[i]+dp2[i];
            }
        }

        System.out.println(op);

    }
}
