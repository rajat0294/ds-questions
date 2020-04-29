package nqueen;

public class Nknight {

    public static void nKnight(boolean[][] chess,int qpsf,String ansf,int block)
    {
        if(qpsf==chess.length*chess[0].length)
        {
            System.out.println(ansf);
            return;
        }
        for(int i=block+1;i<chess.length*chess[0].length;i++)
        {
            int row=i/chess.length;
            int col=i%chess.length;
            if(chess[row][col]==false && isKnightSafe(chess,row,col)) {
                chess[row][col] = true;
                nKnight(chess, qpsf + 1, ansf + "b[" + i + "] q" + qpsf, i);
                chess[row][col] = false;
            }
        }
    }

    private static boolean isKnightSafe(boolean[][] chess, int row, int col) {
        int dirs[][] = {
                {+1, 2},//NORTH
                {+1, -2}, //South
                {-1, 2},//WEST
                {-1, -2},//EAST
                {2, 1},//NORTH WEST
                {2, -1}, //South WEST
                {-2, 1},//NORTH EAST
                {-2, -1} //South EAST
        };

        for (int di = 0; di < chess.length; di++) {
            for (int dis = 1; true; dis++) {
                int eqRow = row + dirs[di][0];
                int eqCol = col + dirs[di][1];

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
