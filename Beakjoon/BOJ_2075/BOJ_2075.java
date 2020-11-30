package BOJ_2075;

import java.io.*;
import java.util.*;

public class BOJ_2075 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
        }
        for (int i = 0; i < n-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
