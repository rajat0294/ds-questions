package dp;

public class CoinChangeProblem {

    public static  int count;
    public static void countCoinChangeCombinations(int[] coins,int sum,int lastindex)
    {
        if (sum == 0) {
            count++;
        }
        for(int i=lastindex;i<coins.length;i++)
        {
            if(sum-coins[i]>=0) {
               countCoinChangeCombinations(coins, sum - coins[i], i);
            }
        }
    }

    public static int countCoinChangeMemoized(int[] coins,int sum,int lastindex,int[] qb){
        if(qb[sum]!=0) {
            return qb[sum];
        }
        if(sum==0){
            return 1;
        }
        for(int i=lastindex;i<coins.length;i++) {
            if(sum-coins[i]>=0) {
               count+=countCoinChangeMemoized(coins, sum - coins[i], i,qb);
            }
        }
        return 0;
    }


    public static int countCoinTabulated(int[] coins,int sum)
    {
        int[] dp=new int[sum+1];
        dp[0]=1;
        for(int i=1;i<=sum;i++){
            int count=0;
            for(int j=0;j<coins.length;j++) {
                if(i-coins[j]>=0) {
                    count += dp[i - coins[j]];
                }
            }
            dp[i]=count;
        }
        for(int i=0;i<=sum;i++)
        {
            System.out.println(i);
        }
        return dp[sum];
    }


    public static void main(String[] args){
        int[] coins=new int[]{2,3,5,6};
        System.out.println(countCoinTabulated(coins,10));

    }
}
