package pathInBoardGame;

public class PathInBoardGame {

    public static int pathInBoardGameMemoized() {
        return 0;
    }

    public static void main(String[] args) {
        int n=10;
        int[] dp=new int[n+1];
        System.out.println(pathInBoardGameTabulated(dp,0,10));
    }

    public static int pathInBoardGameTabulated(int[] dp, int src, int destination) {
     dp[0]=1;
     dp[1]=1;
     dp[2]=2;
     dp[3]=4;
     dp[4]=8;
     dp[5]=16;
     dp[6]=32;
     for(int i=6;i<=destination;i++)
     {
         dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4]+dp[i-5]+dp[i-6];
     }
        return dp[destination];
    }
}
