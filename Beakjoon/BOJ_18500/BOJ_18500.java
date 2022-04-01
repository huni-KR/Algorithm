package BOJ_18500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18500 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int R, C, N;
    static char[][] arr;
    static int[][] visit;
    static int[] arrow;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y;

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
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        arrow = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrow[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int a = 0; a < arrow.length; a++) {
            boolean LeftToRight = a % 2 == 0 ? true : false;
            throwArray(LeftToRight, arrow[a]); // 던지기 & 부수기

            int num = checkFly(); // 공중부양 체크
            if (num > 0) { // 중력 작용
                int distance = getDistance(num);
                down(num, distance);
            }
        }
        sb = new StringBuilder();
        toSb();
        bw.write(sb.toString());
        bw.flush();

    }

    private static int getDistance(int num) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) { // x
            int low = R;
            int high = -1;
            for (int j = 0; j < R; j++) { // y
                if (arr[j][i] == 'x') {
                    if (visit[j][i] == num) {
                        high = j;
                    } else {
                        low = j;
                    }

                    if (high < low && high != -1) {
                        distance = Math.min(distance, low - high);
                    }
                }

            }

        }
        return Math.abs(distance) - 1;
    }

    private static void toSb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
    }

    private static void down(int num, int distance) {
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j] == num && arr[i][j] == 'x') {
                    arr[i + distance][j] = 'x';
                    arr[i][j] = '.';
                }
            }
        }
    }

    private static int checkFly() {
        visit = new int[R][C];
        int num = 1;
        boolean isFly = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'x' && visit[i][j] == 0) {
                    isFly = BFS(j, i, num++);
                }
                if (isFly) {
                    return num - 1;
                }
            }
        }
        return -1;
    }

    private static boolean BFS(int j, int i, int num) {
        boolean isFly = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(j, i));
        visit[i][j] = num;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.y == R - 1) {
                isFly = false;
            }

            for (int dic = 0; dic < 4; dic++) {
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    continue;
                }

                if (arr[ny][nx] == '.') {
                    continue;
                }

                if (visit[ny][nx] == 0) {
                    visit[ny][nx] = num;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return isFly;
    }

    private static void throwArray(boolean leftToRight, int h) {
        h = R - h - 1;
        int start = 0, end = 0, dir = 0;
        if (leftToRight) {
            start = 0;
            end = C - 1;
            dir = 1;
            for (int i = start; i <= end; i += dir) {
                if (arr[h][i] == 'x') {
                    arr[h][i] = '.';
                    break;
                }
            }
        } else {
            start = C - 1;
            end = 0;
            dir = -1;
            for (int i = start; i >= end; i += dir) {
                if (arr[h][i] == 'x') {
                    arr[h][i] = '.';
                    break;
                }
            }
        }
    }
}