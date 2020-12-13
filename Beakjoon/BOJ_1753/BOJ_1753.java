package BOJ_1753;

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

public class BOJ_1753 {

    static ArrayList<Data>[] list;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startPos = Integer.parseInt(br.readLine());

        list = new ArrayList[nV + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Data(e, w));
        }
        br.close();

        visit = new boolean[nV + 1];
        arr = new int[nV + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        dijkstra(startPos);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < arr.length; i++) {
            if (visit[i]) {
                bw.write(Integer.toString(arr[i]) + "\n");
            } else {
                bw.write("INF\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int startPos) {

        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(startPos, 0));
        arr[startPos] = 0;

        while (!pq.isEmpty()) {
            int pos = pq.poll().end;

            if (visit[pos])
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
