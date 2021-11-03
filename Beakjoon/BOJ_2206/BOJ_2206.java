package BOJ_2206;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object a) {
        Point obj = (Point) a;
        return (obj.x == this.x && obj.y == this.y);
    }

    @Override
    public int hashCode() {
        return (Integer.toString(x) + "000000" + Integer.toString(y)).hashCode();
    }
}

public class BOJ_2206 {

    static int[][] arr;
    static int[][] visit;
    static boolean[][] bVisit;
    static int x, y;
    static boolean flag;
    static HashSet<Point> walls;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        flag = true;

        arr = new int[y][x];
        visit = new int[y][x];
        bVisit = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = (int) (str.charAt(j) - '0');
            }
        }

        walls = findWalls();

        int min = Integer.MAX_VALUE;
        for (Point p : walls) {
            initVisit();

            arr[p.y][p.x] = 0;
            min = Math.min(min, bfs());
            arr[p.y][p.x] = 1;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void initVisit() {
        for (int i = 0; i < y; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
    }

    private static HashSet<Point> findWalls() {

        HashSet<Point> set = new HashSet<Point>();
        Queue<Point> queue = new LinkedList<>();
        bVisit[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int dic = 0; dic < 4; dic++) {
                int nx = point.x + dx[dic];
                int ny = point.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= arr[0].length || ny >= arr.length) {
                    continue;
                }

                if (arr[ny][nx] == 1) {
                    set.add(new Point(nx, ny));
                }

                if (arr[ny][nx] == 0 && bVisit[ny][nx] == false) {
                    bVisit[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return set;
    }

    private static int bfs() {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int dic = 0; dic < 4; dic++) {
                int nx = point.x + dx[dic];
                int ny = point.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= arr[0].length || ny >= arr.length) {
                    continue;
                }

                if (arr[ny][nx] == 1 && flag) {

                }

                if (arr[ny][nx] == 0 && visit[ny][nx] > visit[point.y][point.x] + 1) {
                    visit[ny][nx] = visit[point.y][point.x] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return visit[y - 1][x - 1];
    }
}