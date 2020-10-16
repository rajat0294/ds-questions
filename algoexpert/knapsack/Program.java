package knapsack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Program {
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.

        int dp[][]=new int[items.length][capacity+1];

        for(int i=0;i<items.length;i++){
            dp[i][0]=0;
        }

        for(int j=1;j<=capacity;j++){
            if(j-items[0][1]>=0){
                dp[0][j]=items[0][0];
            }else{
                dp[0][j]=0;
            }
        }

        for(int i=1;i<items.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j-items[i][1]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-items[i][1]]+items[i][0]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        List<Integer> totalValue = Arrays.asList(dp[items.length-1][capacity]);
        var result = new ArrayList<List<Integer>>();
        var finalItems=new ArrayList<Integer>();
        int i=items.length- 1;
        int j=capacity;
        while(i>=0 &&j>0){
            if(dp[i-1][j]!=dp[i][j]){
                finalItems.add(i);
                j=j-items[i][1];
                i=i-1;
            }else{
                i=i-1;
            }
            if(j==0){
                break;
            }
        }
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }
}