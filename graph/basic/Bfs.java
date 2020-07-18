package basic;

import basic.Edge;
import basic.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        Edge edge1 = new Edge(0, 1);
        Edge edge2 = new Edge(1, 2);
        Edge edge3 = new Edge(0, 2);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        boolean[] visited = new boolean[graph.getV()];
        int[] edgeTo = new int[graph.getV()];
        bfs(graph, 0, visited, edgeTo);
    }

    public static void bfs(Graph g, int src, boolean[] visited, int[] edgeTo) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            Integer ele = queue.poll();
            for (Integer adjEle : g.getAdjList(ele)) {
                if (!visited[adjEle]) {
                    queue.add(adjEle);
                    visited[adjEle] = true;
                    edgeTo[adjEle] = src;
                }
            }
        }
    }
}
