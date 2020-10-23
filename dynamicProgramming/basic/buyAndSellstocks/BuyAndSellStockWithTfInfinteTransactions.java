package basic.buyAndSellstocks;

import java.util.Scanner;

public class BuyAndSellStockWithTfInfinteTransactions {

        public static void main(String[] args) throws Exception {
            // write your code here
            Scanner scn=new Scanner(System.in);
            int n=scn.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }
            int fee=scn.nextInt();
            int profit=getMaxProfit(arr,fee);
            System.out.println(profit);

        }

        public static int getMaxProfit(int[] arr,int fee){
            int obsp=-arr[0];
            int ossp=0;
            for(int i=1;i<arr.length;i++){
                int nbsp,nssp;
                if(ossp-arr[i]>obsp){
                    nbsp=ossp-arr[i];
                }else{
                    nbsp=obsp;
                }

                if((obsp+arr[i]-fee) > ossp){
                    nssp=(obsp+arr[i]-fee);
                }else{
                    nssp=ossp;
                }
                obsp=nbsp;
                ossp=nssp;
            }
            return ossp;
        }

    }
