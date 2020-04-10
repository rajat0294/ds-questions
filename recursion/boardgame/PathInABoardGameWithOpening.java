package boardgame;

public class PathInABoardGameWithOpening {
    /*
    * find the path in a boardGame with opening with one or six(1,6)
    * it only move one position on first 6
    * */
    public static void main(String[] args) {
        printPathFromSourceToDestination(0,10,"",0);
    }

    public static void printPathFromSourceToDestination(int source, int destionation, String path,int counter) {

        if (source == destionation) {
            counter++;
            System.out.println(counter+path);
            return;
        }

        if (source > destionation) {
            return;
        }
        if (source==0) {
            printPathFromSourceToDestination(1, destionation, 1 + path,counter);
            printPathFromSourceToDestination(1, destionation, 6 + path,counter);
        }

        for (int dice = 1; dice < 6; dice++) {
            int inter = source + dice;
            printPathFromSourceToDestination(inter, destionation, dice+path,counter);
        }
    }
}
