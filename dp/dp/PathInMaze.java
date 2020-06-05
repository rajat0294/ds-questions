package dp;

public class PathInMaze {
    //find the count of path in a maze when only horizontal and vertical movements are allowed

    public static int countPathinMaze(int sx, int sy, int dx, int dy) {
        int count = 0;
        if (sx == dx && sy == dy) {
            return 1;
        }
        if (sx > dx || sy > dy) {
            return 0;
        }
        int hCount = countPathinMaze(sx + 1, sy, dx, dy);
        int vCount = countPathinMaze(sx, sy + 1, dx, dy);
        count = hCount + vCount;
        return count;
    }

    public static int countPathinMazeMemoized(int sx, int sy, int dx, int dy, int[][] qb) {
        int count = 0;
        if (sx == dx && sy == dy) {
            return 1;
        }
        if (sx > dx || sy > dy) {
            return 0;
        }
        if (qb[sx][sy] != 0) {
            return qb[sx][sy];
        } else {
            int hCount = countPathinMazeMemoized(sx + 1, sy, dx, dy,qb);
            int vCount = countPathinMazeMemoized(sx, sy + 1, dx, dy,qb);
            count = hCount + vCount;
            qb[sx][sy] = count;
            return count;
        }
    }

    public static int countPathinMazeTabulated(int sx, int sy, int dx, int dy) {
        int[][] dp = new int[dx + 1][dy + 1];
        dp[dx][dy] = 1;
        for (int i = dx; i >= 0; i--) {
            for (int j = dy; j >= 0; j--) {
                if (!(i + 1 > dx) && !(j + 1 > dy)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else if (!(i + 1 > dx)) {
                    dp[i][j] = dp[i + 1][j];
                } else if (!(j + 1 > dy)) {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }
        return dp[sx][sy];
    }

    public static void main(String[] args) {
        int[][] dp=new int[4][4];
        System.out.println("Memoized"+countPathinMazeMemoized(0,0,3,3,dp));
        System.out.println("Recursion"+countPathinMaze(0,0,3,3));
        System.out.println("Tabulated"+countPathinMazeTabulated(0,0,3,3));
    }
}
