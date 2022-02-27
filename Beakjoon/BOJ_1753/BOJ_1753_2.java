package BOJ_1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int V, E, S;
    static int[] dist;
    static boolean[] visit;

    static class Node implements Comparable<Node> {
        int v;
        int dist;

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        visit = new boolean[V + 1];
        fun(list);

        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void fun(List<List<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.v]) {
                continue;
            }
            visit[node.v] = true;
            
            for (Node n : list.get(node.v)) {
                if (dist[n.v] > dist[node.v] + n.dist) {
                    dist[n.v] = dist[node.v] + n.dist;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }
    }
}