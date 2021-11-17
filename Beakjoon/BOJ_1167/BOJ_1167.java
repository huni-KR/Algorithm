package BOJ_1167;

import java.io.*;
import java.util.*;

public class BOJ_1167 {

    static boolean[] visit;
    static long[] dist;

    static class Node {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        visit = new boolean[V + 1];
        dist = new long[V + 1];
        ArrayList<ArrayList<Node>> tree = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e, w;
            while ((e = Integer.parseInt(st.nextToken())) != -1) {
                w = Integer.parseInt(st.nextToken());
                tree.get(s).add(new Node(e, w));
            }
        }
        System.out.println(diameter(tree));
    }

    private static long diameter(ArrayList<ArrayList<Node>> tree) {
        Arrays.fill(visit, false);
        Arrays.fill(dist, 0);
        DFS(tree, 1, 0);
        int index = findMaxIndex();

        Arrays.fill(visit, false);
        Arrays.fill(dist, 0);
        DFS(tree, index, 0);

        return dist[findMaxIndex()];
    }

    private static int findMaxIndex() {
        int index = 0;
        long max = 0;
        for (int i = 0; i < dist.length; i++) {
            if (max < dist[i]) {
                max = dist[i];
                index = i;
            }
        }
        return index;
    }

    private static void DFS(ArrayList<ArrayList<Node>> tree, int s, long w) {
        visit[s] = true;
        dist[s] = w;

        for (Node node : tree.get(s)) {
            if (!visit[node.e]) {
                dist[node.e] = dist[s] + node.w;
                DFS(tree, node.e, dist[node.e]);
            }
        }
    }
}
