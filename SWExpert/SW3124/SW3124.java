package SW3124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW3124 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, V, E;
    static boolean[] visit;

    static class Data {
        int e, w;

        Data(int e, int w) {
            this.e = e;
            this.w = w;
        }

        public int getE() {
            return e;
        }

        public int getW() {
            return w;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            List<List<Data>> list = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                list.get(s).add(new Data(e, w));
                list.get(e).add(new Data(s, w));
            }

            visit = new boolean[V + 1];
            visit[1] = true;
            long sum = 0;

            PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(Data::getW));
            for (Data data : list.get(1)) {
                pq.add(data);
            }

            int size = 1;
            while (size != V) {
                Data d = pq.poll();
                if (visit[d.e]) {
                    continue;
                }

                visit[d.e] = true;
                size++;
                sum += d.w;

                for (Data data : list.get(d.e)) {
                    pq.add(data);
                }
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Long.toString(sum));
            bw.write("\n");
        }

        bw.flush();
    }
}