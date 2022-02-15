package BOJ_2564;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2564 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int X, Y, C;
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
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N + 1];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int dic = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            switch (dic) {
                case 1:
                    points[i] = new Point(pos, 0);
                    break;
                case 2:
                    points[i] = new Point(pos, Y);
                    break;
                case 3:
                    points[i] = new Point(0, pos);
                    break;
                case 4:
                    points[i] = new Point(X, pos);
                    break;
            }
        }
        int[][] arr = new int[Y + 1][X + 1];
        boolean[][] visit = new boolean[Y + 1][X + 1];
        for (int i = 1; i < Y; i++) {
            for (int j = 1; j < X; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(points[N]);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point point = queue.poll();
                visit[point.y][point.x] = true;
                for (int dic = 0; dic < 4; dic++) {
                    int nx = point.x + dx[dic];
                    int ny = point.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= X + 1 || ny >= Y + 1) {
                        continue;
                    }

                    if (visit[ny][nx]) {
                        continue;
                    }

                    if (arr[ny][nx] < arr[point.y][point.x] + 1) {
                        arr[ny][nx] = arr[point.y][point.x] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += arr[points[i].y][points[i].x];
        }

        System.out.println(sum);
    }
}
