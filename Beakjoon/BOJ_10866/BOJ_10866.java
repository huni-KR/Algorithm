package BOJ_10866;

import java.io.*;
import java.util.*;

public class BOJ_10866 {

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                deque.addFirst(value);
            } else if (command.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                deque.addLast(value);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(Integer.toString(-1));
                    sb.append("\n");
                } else {
                    sb.append(Integer.toString(deque.pollFirst()));
                    sb.append("\n");
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(Integer.toString(-1));
                    sb.append("\n");
                } else {
                    sb.append(Integer.toString(deque.pollLast()));
                    sb.append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(Integer.toString(deque.size()));
                sb.append("\n");
            } else if (command.equals("empty")) {
                sb.append(Integer.toString(deque.isEmpty() ? 1 : 0));
                sb.append("\n");
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(Integer.toString(-1));
                    sb.append("\n");
                } else {
                    sb.append(Integer.toString(deque.peekFirst()));
                    sb.append("\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(Integer.toString(-1));
                    sb.append("\n");
                } else {
                    sb.append(Integer.toString(deque.peekLast()));
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}