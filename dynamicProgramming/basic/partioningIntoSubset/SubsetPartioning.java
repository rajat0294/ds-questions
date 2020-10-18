package basic.partioningIntoSubset;

public class SubsetPartioning {
    public static void main(String[] args) {
        System.out.println(getPartioningWays(4,3));
    }

    public static int getPartioningWays(int n,int k){
        int[][] dp=new int[n+1][k+1];
        dp[1][1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(i>j){
                    dp[i][j]=((i-1)*dp[i-1][j])+dp[i-1][j-1];
                }else if(i==j){
                    dp[i][j]=1;
                }
            }
        }
        return dp[n][k];
    }
}
