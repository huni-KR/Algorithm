package BOJ_1194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1194 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static char[][] arr;
    static int[][][] visit;
    static Point start;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y, h;

        Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == '0') {
                    start = new Point(j, i, 0);
                }
            }
        }

        visit = new int[N][M][64];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start.x, start.y, 0));
        visit[start.y][start.x][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // System.out.println(p.x + " " + p.y + " " + p.h);

            if (arr[p.y][p.x] == '1') {
                return visit[p.y][p.x][p.h];
            }

            for (int dic = 0; dic < 4; dic++) {
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];
                int nh = p.h;
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }

                if (arr[ny][nx] == '#') {
                    continue;
                }

                if (Character.isUpperCase(arr[ny][nx])) {
                    int ch = 1 << (arr[ny][nx] - 'A');
                    if ((p.h & ch) != ch) {
                        continue;
                    }
                } else if (Character.isLowerCase(arr[ny][nx])) {
                    int ch = 1 << (arr[ny][nx] - 'a');
                    if ((p.h & ch) != ch) {
                        nh |= ch;
                    }
                }
                
                if (visit[ny][nx][nh] > visit[p.y][p.x][p.h] + 1) {
                    visit[ny][nx][nh] = visit[p.y][p.x][p.h] + 1;
                    queue.add(new Point(nx, ny, nh));
                }
            }
        }
        return -1;
    }
}