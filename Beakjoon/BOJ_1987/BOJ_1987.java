package BOJ_1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int R, C, max;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }

        visit = new boolean[R][C];
        Set<Character> set = new HashSet<>();
        visit[0][0] = true;
        max = 1;
        fun(set, new Point(0, 0));
        System.out.println(max);
    }

    private static void fun(Set<Character> set, Point point) {
        set.add(arr[point.y][point.x]);
        for (int dic = 0; dic < 4; dic++) {
            int nx = point.x + dx[dic];
            int ny = point.y + dy[dic];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                continue;
            }

            if (set.contains(arr[ny][nx])) {
                continue;
            }

            if (!visit[ny][nx]) {
                visit[ny][nx] = true;
                fun(set, new Point(nx, ny));
                visit[ny][nx] = false;
            }
        }

        max = Math.max(max, set.size());
        set.remove(arr[point.y][point.x]);
    }
}