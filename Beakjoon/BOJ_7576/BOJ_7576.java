package BOJ_7576;

import java.io.*;
import java.util.*;

public class BOJ_7576 {

    static class Point {
        int x;
        int y;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static int x;
    static int y;
    static int[][] arr;
    static List<Point> list;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dx = new int[] { 0, 1, 0, -1 };
        dy = new int[] { -1, 0, 1, 0 };

        arr = new int[y][x];
        list = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }

        fun();

        System.out.println(result());
    }

    private static int result() {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        return max - 1;
    }

    private static void fun() {

        Queue<Point> queue = new LinkedList<>();
        for (Point p : list) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Point point = queue.poll();

                for (int dic = 0; dic < 4; dic++) {
                    int nx = point.x + dx[dic];
                    int ny = point.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
                        continue;
                    }

                    if (arr[ny][nx] == 0) {
                        arr[ny][nx] = arr[point.y][point.x] + 1;
                        queue.add(new Point(ny, nx));
                    }
                }
            }
        }
    }
}