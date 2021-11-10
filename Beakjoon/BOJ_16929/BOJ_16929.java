package BOJ_16929;

import java.io.*;
import java.util.*;

public class BOJ_16929 {

    static boolean cycle;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        arr = new char[col][row];
        visit = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            String str = br.readLine();
            for (int j = 0; j < row; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        checkCycle();

        System.out.println(cycle ? "Yes" : "No");
    }

    private static void checkCycle() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                initVisit();
                DFS(arr[i][j], j, i, j, i, 0);
                if (cycle) {
                    return;
                }
            }
        }
    }

    private static void DFS(char c, int nx, int ny, int sx, int sy, int count) {

        if (arr[ny][nx] == c && count >= 3 && nx == sx && ny == sy) {
            cycle = true;
            return;
        }

        if (!visit[ny][nx]) {
            visit[ny][nx] = true;
            for (int dic = 0; dic < 4; dic++) {
                int nowx = nx + dx[dic];
                int nowy = ny + dy[dic];

                if (nowx < 0 || nowy < 0 || nowx >= arr[0].length || nowy >= arr.length) {
                    continue;
                }

                if (arr[nowy][nowx] == c) {
                    DFS(c, nowx, nowy, sx, sy, count + 1);
                }

                if (cycle) {
                    return;
                }
            }
        }

    }

    private static void initVisit() {
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], false);
        }
    }
}