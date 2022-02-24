package BOJ_1197;

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

public class BOJ_1197 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static List<List<Node>> list;
    static PriorityQueue<Node> pq;
    static int V, E, result;

    static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.get(A).add(new Node(B, C));
            list.get(B).add(new Node(A, C));
        }

        boolean[] visit = new boolean[V + 1];

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int count = 0;
        while (true) {
            Node node = pq.poll();

            if (visit[node.e]) {
                continue;
            }

            visit[node.e] = true;
            result += node.w;
            count++;

            if (count == V) {
                break;
            }

            for (Node n : list.get(node.e)) {
                if (!visit[n.e] && dist[n.e] > n.w) {
                    dist[n.e] = n.w;
                    pq.add(new Node(n.e, dist[n.e]));
                }
            }
        }

        System.out.println(result);
    }
}