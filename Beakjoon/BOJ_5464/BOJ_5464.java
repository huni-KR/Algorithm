package BOJ_5464;

import java.io.*;
import java.util.*;

public class BOJ_5464 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int[] weight = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;

        int[] visit = new int[n];
        Arrays.fill(visit, -1);
        for (int i = 0; i < 2 * m; i++) {

            int value = Integer.parseInt(br.readLine());

            if (value > 0) {
                value--;
                if (isFull(visit)) {
                    queue.add(value);
                    continue;
                } else {
                    insert(visit, value);
                }
            } else {
                value = Math.abs(value) - 1;
                int pos = delete(visit, value);
                sum += price[pos] * weight[value];

                if (!queue.isEmpty()) {
                    insert(visit, queue.poll());
                }
            }
        }

        System.out.println(sum);
    }

    private static int delete(int[] visit, int tmp) {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == tmp) {
                visit[i] = -1;
                return i;
            }
        }
        return -1;
    }

    private static void insert(int[] visit, int tmp) {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == -1) {
                visit[i] = tmp;
                break;
            }
        }
    }

    private static boolean isFull(int[] visit) {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == -1) {
                return false;
            }
        }
        return true;
    }
}
