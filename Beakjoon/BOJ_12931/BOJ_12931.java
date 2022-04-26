package BOJ_12931;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12931 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, answer;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        // 0 : num / 1 : 나누기 / 2 : 빼기
        for (int i = 0; i < N; i++) {
            fun(i);
        }

        int sum = 0, max = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][2];
            max = Math.max(max, arr[i][1]);
        }
        System.out.println(sum + max);
    }

    private static void fun(int i) {
        while (arr[i][0] != 0) {
            if (arr[i][0] % 2 == 0) {
                arr[i][0] /= 2;
                arr[i][1]++;
            } else {
                arr[i][0]--;
                arr[i][2]++;
            }
        }
    }
}