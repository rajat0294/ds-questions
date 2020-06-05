package dp;

public class GoldmineProblem {

    public static int goldmine(int[][] mine) {
        //Tabulation
        int dp[][] = new int[mine.length][mine[0].length];
        for (int i = 0; i < mine.length; i++) {
            dp[i][mine[0].length - 1] = mine[i][mine[0].length-1];
            System.out.println(dp[i][mine[0].length-1]);
        }

        for (int j = mine[0].length - 2; j >= 0; j--) {
            for (int i = 0; i < mine.length; i++) {
                if (!(i - 1 < 0) && !(i + 1 > mine.length-1)) {
                    dp[i][j] = mine[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i][j + 1]), dp[i - 1][j + 1]);
                } else if (i== 0) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else if (i == mine.length-1) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int row = 0; row < mine.length; row++) {
            if (dp[row][0] > max) {
                max = dp[row][0];
            }
            System.out.println(dp[row][2]);
        }
        return max;
    }

    //memoized

    public static void main(String[] args) {
        int[][] mine=new int[][]{
                {2,6,0,5},
                {0,7,5,2},
                {3,0,3,7},
                {8,0,2,3}
        };
        System.out.println(goldmine(mine));
    }
}
