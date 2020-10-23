package basic.buyAndSellstocks;

import java.util.Scanner;

public class BuyAndSellStocksOneTransactionAllowed {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=scanner.nextInt();
        }

        int lsf= Integer.MAX_VALUE;
        int pst=0;
        int op=0;
        for(int i=0;i<n;i++){
            lsf=Math.min(lsf,prices[i]);
            pst=prices[i]-lsf;
            op=Math.max(pst,op);
        }

        System.out.println(op);
    }

}
