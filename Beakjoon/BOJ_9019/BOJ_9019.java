package BOJ_9019;

import java.io.*;
import java.util.*;

public class BOJ_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(BFS(s, e));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Data {
        int value;
        String str;

        Data(int value, String str) {
            this.value = value;
            this.str = str;
        }
    }

    private static String BFS(int s, int e) {
        StringBuilder sb = new StringBuilder();
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(s, ""));

        while (!queue.isEmpty()) {
            Data data = queue.poll();

            sb = new StringBuilder(data.str);
            int D = goD(data.value);
            sb.append("D");
            if (D == e) {
                break;
            } else {
                queue.add(new Data(D, sb.toString()));
            }

            sb = new StringBuilder(data.str);
            int S = goS(data.value);
            sb.append("S");
            if (S == e) {
                break;
            } else {
                queue.add(new Data(S, sb.toString()));
            }

            sb = new StringBuilder(data.str);
            int L = goL(data.value);
            sb.append("L");
            if (L == e) {
                break;
            } else {
                queue.add(new Data(L, sb.toString()));
            }

            sb = new StringBuilder(data.str);
            int R = goR(data.value);
            sb.append("R");
            if (R == e) {
                break;
            } else {
                queue.add(new Data(R, sb.toString()));
            }
        }

        return sb.toString();
    }

    private static int goR(int now) {
        int result = (now / 1000 + now * 10) % 10000;
        return result;
    }

    private static int goS(int now) {
        return (now - 1) % 10000;
    }

    private static int goD(int now) {
        return (now * 2) % 10000;
    }

    private static int goL(int now) {
        int result = (now * 10 + now / 1000) % 10000;
        return result;
    }

}