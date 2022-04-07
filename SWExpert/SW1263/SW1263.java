package SW1263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW1263 {

    static final int INF = 100000000;

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && arr[i][j] == 0) {
                        arr[i][j] = INF;
                    }
                }
            }

            for (int a = 0; a < N; a++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][a] + arr[a][j]);
                    }
                }
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(clacMin()));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int clacMin() {
        int min = INF;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
