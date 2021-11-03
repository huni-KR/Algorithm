import java.util.*;

class Edge {
    int weight;
    int v;

    Edge(int weight, int v) {
        this.weight = weight;
        this.v = v;
    }

    public Edge() {
    }
}

public class P04 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 3;
        int start = 1;
        int end = 3;

        int[][] roads = { { 1, 2, 2 }, { 3, 2, 3 } };
        int[] traps = { 2 };

        System.out.println(s.solution(n, start, end, roads, traps));
    }
}

class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new Edge());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).v = roads[i][1];
            graph.get(roads[i][0]).weight = roads[i][2];
        }

        return BFS(start, end, graph, traps);
    }

    private int BFS(int start, int end, List<Edge> graph, int[] traps) {
        int result = 0;

        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(start, 0));

        return result;
    }

}