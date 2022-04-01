package BOJ_3015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3015 {
    static BufferedReader br;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long count = 0;
        for (int i = 0; i < N - 1; i++) {
            int point = arr[i];
            int subMax = 0;
            for (int j = i + 1; j < N; j++) {
                if (i + 1 == j) {
                    subMax = arr[j];
                } else {
                    subMax = Math.max(subMax, arr[j]);
                }

                if (subMax > arr[j]) {
                    continue;
                }

                count++;

                if (point < arr[j]) {
                    break;
                }
            }
        }
        System.out.println(count);

    }
}