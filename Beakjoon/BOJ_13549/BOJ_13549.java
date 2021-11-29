package BOJ_13549;

import java.io.*;
import java.util.*;

public class BOJ_13549 {
    static class Data implements Comparable<Data> {
        int pos;
        int w;

        Data(int pos, int w) {
            this.pos = pos;
            this.w = w;
        }

        @Override
        public int compareTo(Data o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        PriorityQueue<Data> queue = new PriorityQueue<>();
        queue.add(new Data(N, 0));

        while (!queue.isEmpty()) {
            Data data = queue.poll();
            visit[data.pos] = true;

            if (data.pos == K) {
                System.out.println(data.w);
                return;
            }

            if (data.pos * 2 <= 100000 && !visit[data.pos * 2]) {
                queue.add(new Data(data.pos * 2, data.w));
            }

            if (data.pos + 1 <= 100000 && !visit[data.pos + 1]) {
                queue.add(new Data(data.pos + 1, data.w + 1));
            }

            if (data.pos - 1 >= 0 && !visit[data.pos - 1]) {
                queue.add(new Data(data.pos - 1, data.w + 1));
            }
        }
    }
}