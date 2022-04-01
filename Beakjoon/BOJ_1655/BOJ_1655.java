package BOJ_1655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1655 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (i == 0) {
                pqMax.offer(value);
            } else if (i == 1) {
                pqMax.offer(value);
                pqMin.offer(pqMax.poll());
            } else {
                pqMax.offer(value);

                if (pqMax.peek() > pqMin.peek()) {
                    pqMin.offer(pqMax.poll());
                }

                if (pqMax.size() < pqMin.size()) {
                    pqMax.offer(pqMin.poll());
                }

                if (i % 2 == 1) { // 큐 사이즈 합이 짝수
                    if (pqMax.size() > pqMin.size()) {
                        pqMin.offer(pqMax.poll());
                    }
                }
            }

            bw.write(Integer.toString(pqMax.peek()));
            bw.write("\n");
        }
        bw.flush();

    }
}
