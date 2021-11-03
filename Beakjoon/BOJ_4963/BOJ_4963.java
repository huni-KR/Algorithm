package BOJ_4963;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_4963 {

    static boolean[][] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(fun());

        }
    }

    private static int fun() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int y, int x) {
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int dic = 0; dic < 8; dic++) {
                int nx = point.x + dx[dic];
                int ny = point.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= arr[0].length || ny >= arr.length) {
                    continue;
                }

                if (!visit[ny][nx] && arr[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
