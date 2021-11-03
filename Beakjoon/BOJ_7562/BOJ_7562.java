package BOJ_7562;

import java.io.*;
import java.util.*;

public class BOJ_7562 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr, visit;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            size = Integer.parseInt(br.readLine());
            arr = new int[size][size];
            visit = new int[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point s = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine(), " ");
            Point e = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(fun(s, e));
        }

    }

    private static int fun(Point s, Point e) {

        if (s.x == e.x && s.y == e.y) {
            return 0;
        }

        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(s);
        visit[s.y][s.x] = 0;

        int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
        int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

        while (true) {
            Point p = queue.poll();
            for (int dic = 0; dic < 8; dic++) {
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }

                if (ny == e.y && nx == e.x) {
                    return visit[p.y][p.x] + 1;
                }

                if (visit[ny][nx] > visit[p.y][p.x] + 1) {
                    visit[ny][nx] = visit[p.y][p.x] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
