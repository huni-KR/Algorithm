package SW4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW4014 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, X;
    static int[][] arr, brr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            brr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    brr[j][i] = arr[i][j];
                }
            }

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(fun()));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int fun() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                int last = arr[i][j - 1];
                int now = arr[i][j];
                if (last == now + 1 && count >= 0) {// 현재가 한칸 더 큰 경우
                    // 거리 조건 만족 확인
                    count = 1 - X;
                } else if (last + 1 == now && count >= X) {// 현재가 한칸 더 작은 경우
                    // 거리 조건 만족 확인
                    count = 1;
                } else if (last == now) {// 현재 과거 같은 경우
                    count++;
                } else {// 현재 과거 한칸 초과 경우
                    count = -1;
                    break;
                }
            }
            if (count >= 0) {
                result++;
            }

            count = 1;
            for (int j = 1; j < N; j++) {
                int last = arr[j - 1][i];
                int now = arr[j][i];
                if (last == now + 1 && count >= 0) {// 현재가 한칸 더 큰 경우
                    // 거리 조건 만족 확인
                    count = 1 - X;
                } else if (last + 1 == now && count >= X) {// 현재가 한칸 더 작은 경우
                    // 거리 조건 만족 확인
                    count = 1;
                } else if (last == now) {// 현재 과거 같은 경우
                    count++;
                } else {// 현재 과거 한칸 초과 경우
                    count = -1;
                    break;
                }
            }
            if (count >= 0) {
                result++;
            }
        }
        return result;
    }
}