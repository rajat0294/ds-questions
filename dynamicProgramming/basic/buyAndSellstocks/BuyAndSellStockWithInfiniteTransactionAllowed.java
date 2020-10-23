package basic.buyAndSellstocks;

import java.util.Scanner;

public class BuyAndSellStockWithInfiniteTransactionAllowed {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int profit=getMaxProfit(arr);
        System.out.println(profit);
    }

    private static int getMaxProfit(int[] arr) {
        int bd=0,sd=0;
        int profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                sd++;
            }else{
             profit+=arr[sd]-arr[bd];
             bd=sd=i;
            }
        }
        return profit;
    }
}
