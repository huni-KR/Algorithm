package BOJ_1766;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static List<List<Integer>> list;
    static int[] link;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        link = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            link[b]++;
        }

        queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (link[i] == 0) {
                queue.add(i);
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int v = queue.poll();
            sb.append(Integer.toString(v));
            sb.append(" ");

            for (int next : list.get(v)) {
                link[next]--;

                if (link[next] == 0) {
                    queue.add(next);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}