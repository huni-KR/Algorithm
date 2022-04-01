package BOJ_19238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {

    static class Taxi {
        Point point;
        int number;
        int gas;

        Taxi(Point point, int gas) {
            this.point = point;
            this.gas = gas;
        }
    }

    static class Point {
        int x, y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class User {
        Point sPoint;
        Point ePoint;

        User(Point sPoint, Point ePoint) {
            this.sPoint = sPoint;
            this.ePoint = ePoint;
        }
    }

    static int[][] arr;
    static boolean[][] visit;
    static int N, M, G;
    static Taxi taxi;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int distance;
    static User[] users;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int ty = Integer.parseInt(st.nextToken()) - 1;
        int tx = Integer.parseInt(st.nextToken()) - 1;
        taxi = new Taxi(new Point(tx, ty), G);

        users = new User[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;

            users[i] = new User(new Point(sx, sy), new Point(ex, ey));
            arr[sy][sx] = -((i + 1) * 100);
        }

        boolean flag = true;
        for (int i = 0; i < M * 2; i++) {
            distance = 0;
            visit = new boolean[N][N];

            if (i % 2 == 0) {
                flag = BFS(-1);
            } else {
                int index = findIndex();
                flag = BFS(index);
            }

            if (!flag) {
                break;
            }

            taxi.gas -= distance;
            if (taxi.gas < 0) {
                flag = false;
                break;
            }

            if (i % 2 == 1) {
                taxi.gas += distance * 2;
            }
        }

        if (flag) {
            System.out.println(taxi.gas < 0 ? -1 : taxi.gas);
        } else {
            System.out.println(-1);
        }
    }

    private static int findIndex() {
        for (int i = 0; i < users.length; i++) {
            if (taxi.point.x == users[i].sPoint.x && taxi.point.y == users[i].sPoint.y) {
                return i;
            }
        }
        return -1;
    }

    private static boolean BFS(int value) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(taxi.point);
        visit[taxi.point.y][taxi.point.x] = true;

        if (value < 0 && arr[taxi.point.y][taxi.point.x] < 0) {
            arr[taxi.point.y][taxi.point.x] = 0;
            return true;
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            distance++;

            List<Point> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                Point p = queue.poll();

                for (int dic = 0; dic < 4; dic++) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (arr[ny][nx] == 1) {
                        continue;
                    }

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));

                        if (value < 0) {
                            if (arr[ny][nx] < 0) {
                                list.add(new Point(nx, ny));
                            }
                        } else {
                            if (nx == users[value].ePoint.x && ny == users[value].ePoint.y) {
                                taxi.point.x = nx;
                                taxi.point.y = ny;
                                return true;
                            }
                        }
                    }
                }
            }

            if (list.size() > 0) {
                int index = findIndexInList(list);
                arr[users[index].sPoint.y][users[index].sPoint.x] = 0;
                taxi.point.x = users[index].sPoint.x;
                taxi.point.y = users[index].sPoint.y;
                return true;
            }
        }

        return false;
    }

    private static int findIndexInList(List<Point> list) {

        list.sort(Comparator.comparing(Point::getY).thenComparing(Point::getX));
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < users.length; i++) {
            if (list.get(0).x == users[i].sPoint.x && list.get(0).y == users[i].sPoint.y) {
                index = Math.min(i, index);
            }
        }
        return index;
    }
}
