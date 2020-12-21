package BOJ_14938;

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
        return Integer.compare(this.weight, o.weight);
    }
}

public class BOJ_14938 {

    static ArrayList<Data>[] list;
    static int[] item;
    static boolean[] visit;
    static int[] arr;
    static int limit;
    static int count;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nV = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());

        list = new ArrayList[nV + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        item = new int[nV + 1];
        for (int i = 1; i < item.length; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Data(e, w));
            list[e].add(new Data(s, w));
        }

        arr = new int[nV + 1];
        visit = new boolean[nV + 1];

        for (int i = 1; i < list.length; i++) {
            Arrays.fill(visit, false);
            Arrays.fill(arr, 10000000);
            Dijkstra(i);
            max = Math.max(fun(), max);
        }

        System.out.println(max);
    }

    private static int fun() {
        int count = 0;
        for (int i = 1; i < item.length; i++) {
            if (visit[i]) {
                count += item[i];
            }
        }
        return count;
    }

    private static void Dijkstra(int start) {

        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0));
        arr[start] = 0;

        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int pos = data.end;
            int tmp = data.weight;

            if (visit[pos] || tmp > limit)
                continue;
            visit[pos] = true;

            for (int i = 0; i < list[pos].size(); i++) {
                int next = list[pos].get(i).end;
                int weight = list[pos].get(i).weight;

                if (arr[next] > arr[pos] + weight) {
                    arr[next] = Math.min(arr[next], arr[pos] + weight);
                    pq.add(new Data(next, arr[next]));
                }
            }
        }
    }

}
