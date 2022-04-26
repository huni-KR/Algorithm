package BOJ_13305;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13305 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static long[] cost, dist;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dist = new long[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        cost = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < cost.length; i++) {
            cost[i] = Math.min(cost[i], cost[i - 1]);
        }

        long sum = 0;
        for (int i = 0; i < dist.length; i++) {
            sum += dist[i] * cost[i];
        }

        System.out.println(sum);

    }
}
