package BOJ_1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        bw.write("<");
        while (!queue.isEmpty()) {

            for (int i = 0; i < K - 1; i++) {
                int n = queue.poll();
                queue.add(n);
            }
            bw.write(Integer.toString(queue.poll()));
            if (!queue.isEmpty()) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
    }
}