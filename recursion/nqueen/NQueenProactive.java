package nqueen;

public class NQueenProactive {

    public static void nQueen(boolean[][] visited,int lqpb,int qpsf,String ansf)
    {
        if(qpsf==visited.length)
        {
            System.out.println(ansf);
            return;
        }

        for(int block=lqpb+1;block<visited.length *visited.length;block++)
        {
            int row=block/visited.length;
            int col=block%visited.length;
            if(isQueenSafe(visited,row,col)) {
                visited[row][col] = true;
                nQueen(visited, block, qpsf + 1, "b[" + row + "][" + col + "]-q" + qpsf + 1);
                visited[row][col] = false;
            }
        }
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
