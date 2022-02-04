package BOJ_2275;

import java.io.*;
import java.util.*;

public class BOJ_2275 {
    static class Data {
        int e;
        int w;

        Data(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Data>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (p == 0 && w == 0) {
                continue;
            }

            list.get(i + 1).add(new Data(p, w));
            list.get(p).add(new Data(i + 1, w));
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            
        }
        System.out.println();
    }
}