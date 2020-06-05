package dp;


public class MaxSquareProblem {

    public static int maxSquareTabulated(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] == 1) {
                dp[i][m - 1] = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[n - 1][j] == 1) {
                dp[n - 1][j] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static int maxSquareMemoized(int[][] matrix, int sx, int sy, int[][] qb) {

        if (sx == matrix.length - 1 || sy == matrix[0].length - 1) {
            return matrix[sx][sy];
        }
        if (matrix[sx][sy] != 0) {
            if (qb[sx][sy] != 0) {
                return qb[sx][sy];
            }

            int count;
            int left = maxSquareMemoized(matrix, sx + 1, sy, qb);
            int right = maxSquareMemoized(matrix, sx, sy + 1, qb);
            int diag = maxSquareMemoized(matrix, sx + 1, sy + 1, qb);
            count = Math.min(Math.min(left, right), diag);
            qb[sx][sy] = count;
            return count;
        } else {
            return qb[sx][sy];
        }

    }


    public static void main(String[] args) {
        //System.out.println(maxSquareMemoized());
    }
}
