package quadTree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {

    Boundary boundary;
    int capacity;
    List<Point> points;
    boolean divided;
    QuadTree northWest;
    QuadTree northEast;
    QuadTree southWest;
    QuadTree southEast;


    public List<Point> getPoints() {
        return points;
    }

    public QuadTree(Boundary boundary, int capacity) {
        this.boundary = boundary;
        this.capacity = capacity;
        this.points=new ArrayList<>();
        this.divided=false;
    }

    public boolean insert(Point p) {
        if (!boundary.contains(p)) {
            return false;
        }
        if (points.size() < capacity) {
            points.add(p);
            return true;
        } else if (!divided) {
            subdivide();
        }
        if (northEast.insert(p) || northWest.insert(p) || southEast.insert(p) || southWest.insert(p)) {
            return true;
        }
        return false;
    }

    private void subdivide() {
        Boundary northEastBoundary = new Boundary(this.boundary.x - (this.boundary.w / 2), this.boundary.y + (this.boundary.h / 2), this.boundary.w / 2, this.boundary.h / 2);
        this.northEast = new QuadTree(northEastBoundary, this.capacity);
        Boundary northWestBoundary = new Boundary(this.boundary.x + (this.boundary.w / 2), this.boundary.y + (this.boundary.h / 2), this.boundary.w / 2, this.boundary.h / 2);
        this.northWest = new QuadTree(northWestBoundary, this.capacity);
        Boundary southWestBoundary = new Boundary(this.boundary.x + (this.boundary.w / 2), this.boundary.y - (this.boundary.h / 2), this.boundary.w / 2, this.boundary.h / 2);
        this.southWest = new QuadTree(southWestBoundary, this.capacity);
        Boundary southEastBoundary = new Boundary(this.boundary.x - (this.boundary.w / 2), this.boundary.y - (this.boundary.h / 2), this.boundary.w / 2, this.boundary.h / 2);
        this.southWest = new QuadTree(southEastBoundary, this.capacity);
    }

}
