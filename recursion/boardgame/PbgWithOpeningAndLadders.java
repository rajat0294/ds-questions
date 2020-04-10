package boardgame;

public class PbgWithOpeningAndLadders {

    public static void main(String[] args) {
        int[] ladders = new int[16];
        ladders[2] = 13;
        ladders[3] = 11;
        ladders[5] = 7;
        printPathInBoardGameWithLadders(0, 16, ladders, "");
    }

    /*
    * Print the path in a board game if board has ladders
    * */
    public static void printPathInBoardGameWithLadders(int src, int dest, int[] ladders, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }
        if (src > dest) {
            return;
        }

        if (src == 0) {
            printPathInBoardGameWithLadders(1, dest, ladders, 1 + path);
            printPathInBoardGameWithLadders(1, dest, ladders, 6 + path);
        }
        //ladder is found
        if (ladders[src] != 0) {
            printPathInBoardGameWithLadders(ladders[src], dest, ladders, "[" + src + "->" + ladders[src] + "]");
        } else {
            for (int dice = 1; dice <= 6; dice++) {
                int inter = src + dice;
                printPathInBoardGameWithLadders(inter, dest, ladders, dice + path);
            }
        }

    }
}
