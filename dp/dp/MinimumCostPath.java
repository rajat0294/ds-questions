package dp;

public class MinimumCostPath {

    public static int minCostPathRec(int sx, int sy, int dx, int dy, int[][] cost) {
        if (sx == dx && sy==dy) {
            return cost[dx][dy];
        }
        if (sx > dx || sy > dy) {
            return Integer.MAX_VALUE;
        }
        return cost[sx][sy] + Math.min(minCostPathRec(sx + 1, sy, dx, dy, cost), minCostPathRec(sx, sy + 1, dx, dy, cost));
    }


    public static int minCostPathMemoization(int sx, int sy, int dx, int dy, int[][] cost,int[][] qb) {
        if (sx == dx && sy==dy) {
            return cost[dx][dy];
        }
        if (sx > dx || sy > dy) {
            return Integer.MAX_VALUE;
        }
        if(qb[sx][sy]!=0) {
            return qb[sx][sy];
        }else{
            int minCost=cost[sx][sy] + Math.min(minCostPathRec(sx + 1, sy, dx, dy, cost), minCostPathRec(sx, sy + 1, dx, dy, cost));
            qb[sx][sy]=minCost;
            return minCost;
        }
    }

    public static void main(String[] args) {
        int[][] cost=new int[][]{
                {2,3,0,4},
                {0,6,5,2},
                {8,0,3,7},
                {2,0,4,2}
        };
        int qb[][]=new int[4][4];
        //System.out.println(minCostPathRec(0,0,3,3,cost));
        //System.out.println(minCostPathMemoization(0,0,3,3,cost,qb));
        System.out.println(minCostPathTabulated(0,0,3,3,cost));
    }

    public static int minCostPathTabulated(int sx,int sy,int dx,int dy,int[][] cost)
    {
        int dp[][]=new int[dx+1][dy+1];
        dp[dx][dy]=cost[dx][dy];
        for(int i=dx;i>=0;i--)
        {
            for(int j=dy;j>=0;j--)
            {
                if (!(i + 1 > dx) && !(j + 1 > dy)) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + cost[i][j];
                } else if (!(i + 1 > dx)) {
                    dp[i][j] = cost[i][j] + dp[i + 1][j];
                } else if (!(j + 1 > dy)) {
                    dp[i][j] = cost[i][j] + dp[i][j + 1];
                }
            }
        }
        return dp[sx][sy];
    }
}
