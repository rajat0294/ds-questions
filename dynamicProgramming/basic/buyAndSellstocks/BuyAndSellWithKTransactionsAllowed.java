package basic.buyAndSellstocks;

public class BuyAndSellWithKTransactionsAllowed {

    public static void main(String[] args) {

    }

    public static int maxProfitKTransactions(int[] arr,int k){
        int[][] dp=new int[k+1][arr.length];
        for(int i=1;i<=k;i++){
            for(int j=1;j<arr.length;j++){
                int max=dp[i][j-1];
                for(int l=0;l<j;l++){
                    if(max<dp[i-1][l]+(arr[j]-arr[l])){
                        max=dp[i-1][l]+(arr[j]-arr[l]);
                    }
                }
                dp[i][j]=max;
            }
        }
        return dp[k][arr.length-1];
    }

    public static int maxProfitKTransactionsOptimized(int[] arr,int k){
        int[][] dp=new int[k+1][arr.length];
        for(int i=1;i<=k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<arr.length;j++){
                if(dp[i-1][j-1]-arr[j-1]>max){
                    max=dp[i-1][j-1]-arr[j-1];
                }

                if(max+arr[j]>dp[i][j-1]){
                    dp[i][j]=max+arr[j];
                }
                else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[k][arr.length-1];
    }
}


