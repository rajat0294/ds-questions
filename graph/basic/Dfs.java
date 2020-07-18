package basic;

import java.util.LinkedList;

public class Dfs {


    public static void dfs(Graph graph, int src, boolean[] visited,int[] edgeTo){
        visited[src]=true;
        LinkedList<Integer> adjList=graph.getAdjList(src);
        for(Integer ele:adjList) {
            if (visited[ele] != true) {
                dfs(graph, ele, visited,edgeTo);
                edgeTo[ele]=src;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph(3);
        Edge edge1=new Edge(0,1);
        Edge edge2=new Edge(1,2);
        Edge edge3=new Edge(0,2);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        boolean[] visited=new boolean[graph.v];
        int[] edgeTo=new int[graph.v];
        dfs(graph,0,visited,edgeTo);
    }
}
