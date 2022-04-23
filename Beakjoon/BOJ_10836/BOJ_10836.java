package BOJ_10836;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10836 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static int[] arr;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[3];

        result = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            for (int j = M - 1; j >= 0; j--) {
                if (arr[0] != 0) {
                    arr[0]--;
                } else if (arr[1] != 0) {
                    arr[1]--;
                    result[j][0] += 1;
                } else if (arr[2] != 0) {
                    arr[2]--;
                    result[j][0] += 2;
                }
            }
            for (int j = 1; j < M; j++) {
                if (arr[0] != 0) {
                    arr[0]--;
                } else if (arr[1] != 0) {
                    arr[1]--;
                    result[0][j] += 1;
                } else if (arr[2] != 0) {
                    arr[2]--;
                    result[0][j] += 2;
                }
            }
        }

        fun();

        print();
    }

    private static void fun() throws IOException {
        for (int j = 1; j < M; j++) {
            for (int k = 1; k < M; k++) {
                int max1 = Math.max(result[j - 1][k - 1] - result[j][k], result[j - 1][k] - result[j][k]);
                int max2 = Math.max(result[j - 1][k - 1] - result[j][k], result[j - 1][k] - result[j][k]);
                int value = Math.max(max1, max2);
                result[j][k] = result[j][k] + value;
            }
        }
    }

    private static void print() throws IOException {
        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}