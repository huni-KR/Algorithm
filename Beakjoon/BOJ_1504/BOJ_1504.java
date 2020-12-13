package BOJ_1504;

import java.io.*;
import java.util.*;

class Data implements Comparable<Data> {
    int end;
    int weight;

    Data(int e, int w) {
        this.end = e;
        this.weight = w;
    }

    @Override
    public int compareTo(Data o) {
        return this.weight - o.weight;
    }
}

public class BOJ_1504 {

    static ArrayList<Data>[] list;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());

        visit = new boolean[nV + 1];
        arr = new int[nV + 1];
        list = new ArrayList[nV + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Data(b, w));
            list[b].add(new Data(a, w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, nV);
        long result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, nV);

        if (result1 < result2 && result1 < Integer.MAX_VALUE) {
            System.out.println(result1);
        } else if (result1 > result2 && result2 < Integer.MAX_VALUE) {
            System.out.println(result2);
        } else {
            System.out.println(-1);
        }
    }

    private static long dijkstra(int start, int end) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0));

        Arrays.fill(arr, Integer.MAX_VALUE);
        Arrays.fill(visit, false);

        arr[start] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll().end;

            if (visit[now])
                continue;
            visit[now] = true;

            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i).end;
                int weight = list[now].get(i).weight;

                if (arr[next] > arr[now] + weight) {
                    arr[next] = Math.min(arr[next], arr[now] + weight);
                    pq.add(new Data(next, arr[next]));
                }
            }
        }
        return arr[end];
    }
}