package BOJ_1715;

import java.io.*;
import java.util.*;

public class BOJ_1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        int result = 0;
        while (pq.size() != 1) {
            int tmp = pq.poll() + pq.poll();
            result += tmp;
            pq.add(tmp);
        }

        System.out.println(result);
    }
}
