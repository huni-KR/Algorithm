package BOJ_9466;

import java.io.*;
import java.util.*;

public class BOJ_9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[n + 1];
            boolean[] visit = new boolean[n + 1];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i < arr.length; i++) {
                int now = i;
                int next = arr[i];

                if (visit[next]) {
                    while (!queue.isEmpty()) {
                        visit[queue.poll()] = true;
                    }
                } else {
                    queue.add(next);
                }

            }
            System.out.println();
        }

    }
}