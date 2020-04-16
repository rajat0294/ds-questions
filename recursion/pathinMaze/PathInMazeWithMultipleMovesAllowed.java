package pathinMaze;

public class PathInMazeWithMultipleMovesAllowed {


    public static void printPathinMazeWithMultipleMoves(int sx,int sy,int dx,int dy,String path)
    {
        if (sx == dx && sy == dy) {
            System.out.println(path);
        }
        //Horizontal call
        for (int ma = 1; ma <= dx - sx; ma++) {
            printPathinMazeWithMultipleMoves(sx + ma, sy, dx, dy, path + "H" + ma);
        }
        //Vertical call
        for (int mb = 1; mb <= dy - sy; mb++) {
            printPathinMazeWithMultipleMoves(sx + mb, sy, dx, dy, path + "V" + mb);
        }

        //Diagonal call
        for (int mc = 1; mc <= Math.min(dy - sy, dx - sx); mc++) {
            printPathinMazeWithMultipleMoves(sx + mc, sy + mc, dx, dy, path + "D" + mc);
        }
    }
}
