package BOJ_3109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3109 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int R, C;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = { 1, 1, 1 };
    static int[] dy = { -1, 0, 1 };
    static int count = 0;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            flag = false;
            fun(i, i, 0);
        }
        System.out.println(count);
    }

    private static void fun(int start, int y, int x) {
        if (x == C - 1) {
            count++;
            flag = true;
            return;
        }

        for (int dic = 0; dic < 3; dic++) {
            int nx = x + dx[dic];
            int ny = y + dy[dic];

            if (ny < 0 || nx >= C || ny >= R) {
                continue;
            }

            if (arr[ny][nx] == 'x') {
                continue;
            }

            if (!visit[ny][nx]) {
                visit[ny][nx] = true;
                fun(start, ny, nx);
                if (flag) {
                    return;
                }
            }
        }
    }
}