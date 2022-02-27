package BOJ_9370;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_9370 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, T, S, G, H;
    static int[] candidate;
    static boolean visitG;

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
        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            List<List<Node>> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(s).add(new Node(e, w));
                list.get(e).add(new Node(s, w));
            }

            int[] dist = new int[N + 1];

            candidate = new int[T];
            for (int i = 0; i < T; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i : candidate) {
                int value1 = fun(list, dist, S, G) + fun(list, dist, G, H) + fun(list, dist, H, i);
                int value2 = fun(list, dist, S, H) + fun(list, dist, H, G) + fun(list, dist, G, i);
                int value3 = fun(list, dist, S, i);
                if (Math.min(value1, value2) == value3) {
                    pq.add(i);
                }
            }
            while (!pq.isEmpty()) {
                bw.write(Integer.toString(pq.poll()) + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

    private static int fun(List<List<Node>> list, int[] dist, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visit = new boolean[dist.length];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.v]) {
                continue;
            }
            visit[node.v] = true;

            for (Node n : list.get(node.v)) {
                if (!visit[n.v] && dist[n.v] > dist[node.v] + n.dist) {
                    dist[n.v] = dist[node.v] + n.dist;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }
        return dist[end];
    }
}
