package basic.knapsackProblem;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] value =new int[]{15,14,10,45,30};
        int[] capacity =new int[]{2,5,1,3,4};

        System.out.println(zeroOneKnapsack(capacity,value,7));
    }
    public static int zeroOneKnapsack(int[] capacity,int[] value,int maxCapacity){
        int[][] dp=new int[value.length+1][maxCapacity+1];
        for(int i=1;i<=value.length;i++){
            for(int j=0;j<=maxCapacity;j++){
                 if(j-capacity[i-1]>=0){
                     dp[i][j]=Math.max(dp[i-1][j],(dp[i-1][j-capacity[i-1]]+value[i-1]));
                 }else{
                     dp[i][j]=dp[i-1][j];
                 }
            }
        }
      return dp[value.length][maxCapacity];
    }
}
