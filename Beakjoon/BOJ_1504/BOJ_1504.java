package BOJ_1504;

import java.io.*;
import java.util.*;

public class BOJ_1504 {

    static class Node implements Comparable<Node> {
        int e;
        int w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return (int) (this.w - n.w);
        }
    }

    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] check;
    static final int MAX = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, w));
            list.get(e).add(new Node(s, w));
        }

        int[] must = new int[2];
        st = new StringTokenizer(br.readLine(), " ");
        must[0] = Integer.parseInt(st.nextToken());
        must[1] = Integer.parseInt(st.nextToken());

        int[] result = new int[2];
        result[0] += dijkstra(1, must[0]);
        result[0] += dijkstra(must[0], must[1]);
        result[0] += dijkstra(must[1], N);

        result[1] += dijkstra(1, must[1]);
        result[1] += dijkstra(must[1], must[0]);
        result[1] += dijkstra(must[0], N);

        int answer = (result[0] >= MAX && result[1] >= MAX) ? -1 : Math.min(result[0], result[1]);

        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        Arrays.fill(dist, MAX);
        Arrays.fill(check, false);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.e;
            if (!check[now]) {
                check[now] = true;

                for (Node n : list.get(now)) {
                    if (!check[n.e] && dist[now] + n.w < dist[n.e]) {
                        dist[n.e] = dist[now] + n.w;
                        pq.offer(new Node(n.e, dist[n.e]));
                    }
                }
            }
        }
        return dist[end];
    }
}