package basic;

public class Edge {
    int src;

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    int destination;

    public Edge(int src, int destination) {
        this.src = src;
        this.destination = destination;
    }

}
