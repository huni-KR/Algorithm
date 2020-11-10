package BOJ_14235;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            if (len > 0) {
                for (int j = 0; j < len; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            } else if (pq.isEmpty()) {
                bw.write(Integer.toString(-1) + "\n");
            } else if (!pq.isEmpty()) {
                bw.write(Integer.toString(pq.poll()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}