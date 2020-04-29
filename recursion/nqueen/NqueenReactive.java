package nqueen;

public class NqueenReactive {

    public static void nQueen(boolean[][] visited,int lqpb,int qpsf,String ansf)
    {
        if (qpsf == visited.length && checkBoardSafe(visited)) {
            System.out.println(ansf);
            return;
        }

        for (int block = lqpb + 1; block < visited.length * visited.length; block++) {
            int row = block / visited.length;
            int col = block % visited.length;
            visited[row][col] = true;
            nQueen(visited, block, qpsf + 1, "b[" + row + "][" + col + "]-q" + qpsf + 1);
            visited[row][col] = false;
        }
    }

    public static boolean checkBoardSafe(boolean[][] visited) {
        for (int row = 0; row < visited.length; row++) {
            for (int col = 0; col < visited[row].length; col++) {
                if (visited[row][col] == true) {
                    return isQueenSafe(visited, row, col);
                }
            }
        }
        return true;
    }

    private static boolean isQueenSafe(boolean[][] chess, int row, int col) {
        int dirs[][] = {
                {0, 1},//NORTH
                {0, -1}, //South
                {-1, 0},//WEST
                {1, 0},//EAST
                {-1, 1},//NORTH WEST
                {-1, -1}, //South WEST
                {1, 1},//NORTH EAST
                {1, -1} //South EAST
        };

        for (int di = 0; di < chess.length; di++) {
            for (int dis = 1; true; dis++) {
                int eqRow = row + dirs[di][0] * dis;
                int eqCol = col + dirs[di][1] * dis;

                if (eqRow < 0 || eqRow > chess.length || eqCol < 0 || eqCol > chess[0].length) {
                    break;
                }
                if (chess[eqRow][eqCol] == true) {
                    return false;
                }
            }
        }
        return true;
    }
}
