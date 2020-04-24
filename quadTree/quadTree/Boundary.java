package quadTree;

public class Boundary {

    public double  x;
    public double  y;
    public double  w;
    public double  h;

    public Boundary(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean contains(Point point) {
        if (point.x > x + w || point.x < x - w || point.y > y + h || point.y < y - h) {
            return false;
        }
        return true;
    }

}
