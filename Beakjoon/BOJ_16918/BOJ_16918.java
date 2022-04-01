package BOJ_16918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16918 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int R, C, N;
    static int[][][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == 'O') {
                    arr[0][i][j] = 3;
                    arr[1][i][j] = 2;
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (arr[i - 1][j][k] == 1) {
                        arr[i][j][k] = -1;
                    } else if (arr[i - 1][j][k] == 0) {
                        arr[i][j][k] = 3;
                    } else {
                        arr[i][j][k] = arr[i - 1][j][k] - 1;
                    }
                }
            }
            bomb(i);
        }
        for (int a = 0; a < R; a++) {
            for (int b = 0; b < C; b++) {
                if (arr[N][a][b] > 0) {
                    bw.write('O');
                } else {
                    bw.write('.');
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void bomb(int i) {

        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                if (arr[i][j][k] == -1) {
                    arr[i][j][k] = 0;
                    for (int dic = 0; dic < 4; dic++) {
                        int x = dx[dic] + k;
                        int y = dy[dic] + j;
                        if (x < 0 || y < 0 || x >= C || y >= R) {
                            continue;
                        }
                        if (arr[i][y][x] == -1) {
                            continue;
                        }
                        arr[i][y][x] = 0;
                    }
                }
            }
        }
    }
}
