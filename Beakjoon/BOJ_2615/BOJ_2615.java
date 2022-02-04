package BOJ_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {

    static int n;
    static int[][] arr;
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = 19;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j][i] != 0) {
                    if (check(j, i, arr[j][i])) {
                        System.out.println(arr[j][i] == 1 ? 1 : 2);
                        System.out.println((j + 1) + " " + (i + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean check(int y, int x, int color) {
        for (int dic = 0; dic < 4; dic++) {
            int count = 1;

            count += fun(y, x, color, dic, 0);
            count += fun(y, x, color, (dic + 4) % 8, 0);

            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    private static int fun(int y, int x, int color, int dic, int len) {
        int nx = x + dx[dic];
        int ny = y + dy[dic];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[ny][nx] != color) {
            return len;
        }
        return fun(ny, nx, color, dic, len + 1);
    }
}