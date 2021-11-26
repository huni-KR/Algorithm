package BOJ_11779;

import java.io.*;
import java.util.*;

public class BOJ_11779 {
    static class Data implements Comparable<Data> {
        int e;
        int w;

        Data(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Data>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        int[] weigth = new int[n + 1];
        Arrays.fill(weigth, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(s).add(new Data(e, w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        dijkstra(list, parent, weigth, start);
        Stack<Integer> path = pathFinder(parent, start, end);
        int pathSize = path.size();

        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop() + " ");
        }

        bw.write(weigth[end] + "\n");
        bw.write(pathSize + "\n");
        bw.write(sb.toString());
        bw.flush();
    }

    private static Stack<Integer> pathFinder(int[] parent, int start, int end) {
        Stack<Integer> path = new Stack<>();
        int pos = end;
        while (pos != start) {
            path.push(pos);
            pos = parent[pos];
        }
        path.push(pos);
        return path;
    }

    private static void dijkstra(ArrayList<ArrayList<Data>> list, int[] parent, int[] weigth, int start) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(start, 0));
        weigth[start] = 0;

        boolean[] visit = new boolean[parent.length];
        while (!pq.isEmpty()) {
            Data nowData = pq.poll();
            int pos = nowData.e;
            if (visit[pos]) {
                continue;
            }
            visit[pos] = true;
            for (Data data : list.get(pos)) {
                if (weigth[data.e] > weigth[pos] + data.w) {
                    weigth[data.e] = weigth[pos] + data.w;
                    pq.add(new Data(data.e, weigth[data.e]));
                    parent[data.e] = pos;
                }
            }
        }
    }
}
