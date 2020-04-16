package pathinMaze;

//given an boolean array that has some postions blocked for movement
//Movement is allowed in all directions
public class PathInMazeMovesInallDirection {

    public static void printPathInMazeMovesInallDirection(int sx, int sy, int dx, int dy, boolean[][] allowed, String path) {
        if (sx < 0 || sx > dx || sy > dy || sy < 0 || !allowed[sx][sy]) {
            return;
        }
        if (sx == dx && sy == dy) {
            System.out.println(path);
            return;
        }
        //horizontal movement
        printPathInMazeMovesInallDirection(sx + 1, sy, dx, dy, allowed, path + "R");
        //Vertical movement
        printPathInMazeMovesInallDirection(sx, sy + 1, dx, dy, allowed, path + "D");
        //Top movement
        printPathInMazeMovesInallDirection(sx, sy - 1, dx, dy, allowed, path + "T");
        //Back Movement
        printPathInMazeMovesInallDirection(sx - 1, sy, dx, dy, allowed, path + "B");

    }
}
