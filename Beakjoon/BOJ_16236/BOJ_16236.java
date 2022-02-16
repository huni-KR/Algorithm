package BOJ_16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, move;
    static int[][] arr;
    static boolean[][] visit;
    static Shark shark;
    static int[] dx, dy;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Feed {
        Point point;
        int dist;

        Feed(Point p, int dist) {
            this.point = p;
            this.dist = dist;
        }

        public int getX() {
            return this.point.x;
        }

        public int getY() {
            return this.point.y;
        }
    }

    static class Shark {
        Point point;
        int level;
        int stack;
        List<Feed> feeds;

        Shark(Point p) {
            this.point = p;
            this.level = 2;
            this.stack = 0;
            this.feeds = new ArrayList<>();
        }

        void levelUp() {
            if (level == stack) {
                this.stack = 0;
                this.level++;
            }
        }

        void findFeed() {
            visit = new boolean[N][N];
            Queue<Point> queue = new LinkedList<>();
            queue.add(this.point);
            visit[this.point.y][this.point.x] = true;

            boolean flag = false;
            int count = 0;
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                count++;
                for (int i = 0; i < queueSize; i++) {
                    Point p = queue.poll();
                    for (int dic = 0; dic < 4; dic++) {
                        int nx = p.x + dx[dic];
                        int ny = p.y + dy[dic];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }

                        if (arr[ny][nx] > this.level) {
                            continue;
                        }

                        if (!visit[ny][nx] && arr[ny][nx] > 0 && arr[ny][nx] < this.level) {
                            feeds.add(new Feed(new Point(nx, ny), count));
                            flag = true;
                        }

                        if (!visit[ny][nx] && arr[ny][nx] <= this.level) {
                            visit[ny][nx] = true;
                            queue.add(new Point(nx, ny));
                        }

                    }
                }
                if (flag) {
                    feeds.sort(Comparator.comparing(Feed::getY).thenComparing(Feed::getX));
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        dx = new int[] { 0, -1, 1, 0 };
        dy = new int[] { -1, 0, 0, 1 };

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Shark(new Point(j, i));
                }
            }
        }
        move = 0;

        shark.findFeed();

        while (shark.feeds.size() != 0) {
            arr[shark.point.y][shark.point.x] = 0;
            shark.point = shark.feeds.get(0).point;
            move += shark.feeds.get(0).dist;
            shark.feeds.clear();
            shark.stack++;
            shark.levelUp();

            arr[shark.point.y][shark.point.x] = 9;

            // printArray();

            shark.findFeed();

        }

        System.out.println(move);
    }

    private static void printArray() {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}