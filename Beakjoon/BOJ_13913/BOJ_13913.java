package BOJ_13913;

import java.io.*;
import java.util.*;

public class BOJ_13913 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int bin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());

        int[] visit = new int[100001];
        int[] path = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        visit[bin] = 1;
        path[bin] = bin;
        queue.offer(bin);

        int next;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == bro) {
                System.out.println(visit[now] - 1);

                Stack<Integer> stack = new Stack<>();
                while (path[now] != now) {
                    stack.push(now);
                    now = path[now];
                }
                stack.push(bin);

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop() + " ");
                }
                System.out.println(sb);
                break;
            }

            next = now + 1;
            if (isValue(next) && visit[next] == 0) {
                visit[next] = visit[now] + 1;
                path[next] = now;
                queue.offer(next);
            }

            next = now - 1;
            if (isValue(next) && visit[next] == 0) {
                visit[next] = visit[now] + 1;
                path[next] = now;
                queue.offer(next);
            }

            next = now * 2;
            if (isValue(next) && visit[next] == 0) {
                visit[next] = visit[now] + 1;
                path[next] = now;
                queue.offer(next);
            }
        }
    }

    private static boolean isValue(int pos) {
        return (pos >= 0 && pos <= 100000) ? true : false;
    }
}
