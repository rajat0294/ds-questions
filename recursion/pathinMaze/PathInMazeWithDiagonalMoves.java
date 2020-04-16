package pathinMaze;

public class PathInMazeWithDiagonalMoves {

    public static void pathInMazeWithDiagonal(int sx, int sy, int dx, int dy, String path) {
        if (sx > dx || sy > dy) {
            return;
        }
        if (sx == dx && sy == dy) {
            System.out.println(path);
            return;
        }
        //Horizontal call
        pathInMazeWithDiagonal(sx + 1, sy, dx, dy, "H" + path);
        //Vertical Call
        pathInMazeWithDiagonal(sx, sy + 1, dx, dy, "V" + path);
        //Diagonal Call
        pathInMazeWithDiagonal(sx + 1, sy + 1, dx, dy, "D" + path);
    }
}
