package BOJ_9205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N;
    static Point home, festival;
    static Point[] stores;
    static boolean[] visit;

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

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            stores = new Point[N];
            visit = new boolean[N];
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    home = new Point(x, y);
                } else if (i == N + 1) {
                    festival = new Point(x, y);
                } else {
                    stores[i - 1] = new Point(x, y);
                }
            }
            bw.write(fun() ? "happy" : "sad");
            bw.write("\n");
        }
        bw.flush();
    }

    private static boolean fun() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(home);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int dist = getDistance(p, festival);
            if (dist <= 1000) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                if (!visit[i] && getDistance(p, stores[i]) <= 1000) {
                    visit[i] = true;
                    queue.add(stores[i]);
                }
            }
        }
        return false;
    }

    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
