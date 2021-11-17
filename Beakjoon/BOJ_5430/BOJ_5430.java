package BOJ_5430;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (st.hasMoreTokens()) {
                deque.offerLast(st.nextToken());
            }
            bw.write(fun(deque, function));
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static String fun(Deque<String> deque, String function) {
        boolean isRight = true;
        for (int i = 0; i < function.length(); i++) {
            if (function.charAt(i) == 'D') {
                if (deque.isEmpty()) {
                    return "error\n";
                }

                if (isRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            } else if (function.charAt(i) == 'R') {
                isRight = !isRight;
            }
        }
        return dequeToString(deque, isRight);
    }

    private static String dequeToString(Deque<String> deque, boolean isRight) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isRight) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (deque.isEmpty()) {
                    break;
                }
                sb.append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (deque.isEmpty()) {
                    break;
                }
                sb.append(",");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}