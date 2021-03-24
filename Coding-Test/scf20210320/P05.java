import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int m;

    Point(int x, int y, int m) {
        this.x = x;
        this.y = y;
        this.m = m;
    }
}

public class P05 {

    static int x, y;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static char[][] arr;
    static boolean[][] visit;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new char[y][x];
        visit = new boolean[y][x];

        List<Point> startPoints = new ArrayList<Point>();
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'c') {
                    startPoints.add(new Point(j, i, 0));
                }
            }
        }
        br.close();

        boolean flag = true;
        min = Integer.MAX_VALUE;
        for (Point p : startPoints) {
            for (int i = 0; i < y; i++) {
                Arrays.fill(visit[i], false);
            }

            int tmp = BFS(p);
            if (tmp == Integer.MAX_VALUE) {
                flag = false;
                break;
            }

            min = Math.min(min, tmp);
        }

        System.out.println(flag ? min : -1);
    }

    private static int BFS(Point p) {

        Queue<Point> queue = new LinkedList<Point>();

        visit[p.y][p.x] = true;
        queue.add(p);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Point point = queue.poll();

                for (int dic = 0; dic < 4; dic++) {
                    int nx = point.x + dx[dic];
                    int ny = point.y + dy[dic];
                    int move = point.m;

                    if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
                        continue;
                    }

                    if (arr[ny][nx] == '.' && ny == y - 1) {
                        return move;
                    }

                    if (!visit[ny][nx] && arr[ny][nx] == '.') {
                        if (dic == 0 || dic == 2) {
                            queue.add(new Point(nx, ny, (move + 1)));
                        } else {
                            queue.add(new Point(nx, ny, move));
                        }
                    }
                }
            }
        }
        return Integer.MAX_VALUE;

    }
}