package basic;

import basic.Edge;

import java.util.LinkedList;

public class Graph {
    public int getV() {
        return v;
    }

    int v;
    LinkedList<Integer>[] adjList;

    public Graph(int v) {
        this.v = v;
        this.adjList=new LinkedList[v];
        for(int i=0;i<this.v;i++){
            adjList[i]=new LinkedList<Integer>();
        }
    }

    public void addEdge(Edge e){
        adjList[e.getSrc()].add(e.getDestination());
        adjList[e.getDestination()].add(e.getSrc());
    }

    public LinkedList<Integer> getAdjList(int src){
       return adjList[src];
    }
}
