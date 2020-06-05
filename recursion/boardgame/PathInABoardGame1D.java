package boardgame;

public class PathInABoardGame1D {

   /* public static void main(String[] args) {
        printPathInBoardGame(1,10,"");
    }*/

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

    public static int countPathInBoardGame(int source, int destination) {
        if (source == destination) {
            return 1;
        }
        if (source > destination) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += countPathInBoardGame(source + i, destination);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPathInBoardGame(0, 10));
    }
}
