package pathinMaze;

public class PathInMaze {

    //In a two dimensional maze we have to find the path to destination
    // when only  horizontal and vertical moves are allowed
    public static void main(String[] args) {

    }

    //proactive approach
    public static void printPath(int sx, int sy, int dx, int dy, String path) {
        if (sx == dx && sy == dy) {
            System.out.println(path);
            return;
        }
        if (sx + 1 <= dx) {
            printPath(sx + 1, sy, dx, dy, path + sx + "H ");
        }
        if (sy + 1 <= dy) {
            printPath(sx, sy + 1, dx, dy, path + sy + "V ");
        }
    }

    //reactive Approach
    public static void printPathReactive(int sx, int sy, int dx, int dy, String path) {
        if (sx > dx || sy > dy) {
            return;
        }
        if (sx == dx || sy == dy) {
            System.out.println(path);
            return;
        }
        printPathReactive(sx + 1, sy, dx, dy, path + "H");
        printPathReactive(sx, sy + 1, dx, dy, path + "V");
    }
}
