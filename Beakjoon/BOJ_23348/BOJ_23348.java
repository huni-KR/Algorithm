package BOJ_23348;

import java.io.*;
import java.util.*;

public class BOJ_23348 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < 3; k++) {
                    sum += scores[k] * Integer.parseInt(st.nextToken());
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}