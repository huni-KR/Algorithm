package BOJ_12852;

import java.io.*;
import java.util.*;

public class BOJ_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[1000001];
        int[] parent = new int[1000001];
        parent[n] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visit[n] = true;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if (pos == 1) {
                break;
            }

            if (pos - 1 > 0 && !visit[pos - 1]) {
                parent[pos - 1] = pos;
                visit[pos - 1] = true;
                queue.add(pos - 1);
            }

            if (pos / 2 > 0 && pos % 2 == 0 && !visit[pos / 2]) {
                parent[pos / 2] = pos;
                visit[pos / 2] = true;
                queue.add(pos / 2);
            }

            if (pos / 3 > 0 && pos % 3 == 0 && !visit[pos / 3]) {
                parent[pos / 3] = pos;
                visit[pos / 3] = true;
                queue.add(pos / 3);
            }
        }

        int pos = 1;
        Stack<Integer> stack = new Stack<>();
        while (pos != n) {
            pos = parent[pos];
            stack.push(pos);
        }

        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(Integer.toString(stack.pop()));
            sb.append(" ");
        }
        sb.append("1");

        System.out.println(sb.toString());
    }
}