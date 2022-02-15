package BOJ_16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, m, r;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        dx = new int[] { 0, 1, 0, -1 };
        dy = new int[] { 1, 0, -1, 0 };

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            arr = fun(arr);
        }

        printArray(arr);
    }

    private static int[][] fun(int[][] arr) {
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(tmp[i], -1);
        }

        int sx = 0, sy = 0, nx = 0, ny = 0, lx = 0, ly = 0, dic = 0, level = 0;
        
        while (tmp[sy][sx] == -1) {

            while (true) {

                nx = lx + dx[dic];
                ny = ly + dy[dic];
                if (nx < level || ny < level || nx >= m - level || ny >= n - level) {
                    nx -= dx[dic];
                    ny -= dy[dic];
                    break;
                }

                tmp[ny][nx] = arr[ly][lx];

                lx = nx;
                ly = ny;
            }
            if (nx == sx && ny == sy) {
                sx++;
                sy++;
                lx++;
                ly++;
                level++;
            }
            dic = (dic + 1) % 4;

        }

        return tmp;
    }

    private static void printArray(int[][] arr) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(Integer.toString(arr[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}