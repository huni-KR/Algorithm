package BOJ_17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17135 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] visit;
    static int N, M, D, max;
    static List<Integer> list;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 113 * x + 113 * y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point p = (Point) obj;
                return this.hashCode() == p.hashCode();
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[M];
        fun(0);
        System.out.println(max);
    }

    private static void fun(int depth) {
        if (depth == 3) {

            int[][] copy = copyArray(arr);

            int sum = clac();
            max = Math.max(max, sum);

            arr = copyArray(copy);

            return;
        }

        for (int i = depth; i < M; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            fun(depth + 1);
            visit[i] = false;
        }
    }

    private static int[][] copyArray(int[][] tmp) {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = tmp[i][j];
            }
        }
        return copy;
    }

    private static int clac() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += shot();
            move();
        }
        return sum;
    }

    private static void move() {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = arr[i - 1][j];
                arr[i - 1][j] = 0;
            }
        }
    }

    private static int shot() {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            if (visit[i]) {
                Point point = getPoint(i, N);
                if (point != null) {
                    set.add(point);
                }
            }
        }

        for (Point p : set) {
            int x = p.x;
            int y = p.y;
            arr[y][x] = 0;
        }

        return set.size();
    }

    private static Point getPoint(int x, int y) {
        Point point = null;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 1) {
                    int dist = calc(i, j, y, x);

                    if (dist > D) {
                        continue;
                    }
                    if (min > dist) {
                        min = dist;
                        point = new Point(j, i);
                    }
                }
            }
        }
        return point;
    }

    private static int calc(int y1, int x1, int y2, int x2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}