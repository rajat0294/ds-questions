package boardgame;

public class PbgWithOpeningSnakeAndLadders {


    public static void main(String[] args) {

    }
/*
* Print the destination position of player provided moves as input
* along with snakes & ladders
*  */
    public void pathWithSnakeAndLadders(int src,int dest,int[] snl,int[] moves,int movesIndex)
    {
        if (src == dest) {
            System.out.println("Win!!! ");
            return;
        }
        if (movesIndex == moves.length) {
            System.out.println(src);
            return;
        }

        if (src == 0) {
            if (moves[movesIndex] == 1 || moves[movesIndex] == 6) {
                pathWithSnakeAndLadders(1, dest, snl, moves, movesIndex + 1);
            }else{
                pathWithSnakeAndLadders(src, dest, snl, moves, movesIndex + 1);
            }
        } else {
            //if there is ladder or snake on this position
            if(snl[src]!=0) {
                pathWithSnakeAndLadders(snl[src], dest, snl, moves, movesIndex);
            }
            else {
                if (src+moves[movesIndex]<=dest) {
                    pathWithSnakeAndLadders(src+moves[movesIndex], dest, snl, moves, movesIndex + 1);
                }else
                {
                    pathWithSnakeAndLadders(src, dest, snl, moves, movesIndex + 1);
                }
            }
        }
    }

}
