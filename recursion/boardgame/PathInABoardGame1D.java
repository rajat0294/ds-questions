package boardgame;

public class PathInABoardGame1D {

    public static void main(String[] args) {
        printPathInBoardGame(1,10,"");
    }

    public static void printPathInBoardGame(int source, int destination, String path) {

        if (source == destination) {
            System.out.println(path);
            return;
        }
        if (source > destination) {
            return;
        }
        for (int dice = 1; dice <= 6; dice++) {
            int inter = source + dice;
            printPathInBoardGame(inter, destination, dice + path);
        }
    }
}
