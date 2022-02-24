package BOJ_19236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19236 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, max;

    static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish {
        Point point;
        int dic;

        Fish(Point point, int dic) {
            this.point = point;
            this.dic = dic;
        }
    }

    static class Data {
        int number;
        int dic;

        Data(int number, int dic) {
            this.number = number;
            this.dic = dic;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = 4;
        Data[][] arr = new Data[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // dic 0 위 : 반시계방향
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dic = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j] = new Data(num, dic);
            }
        }

        Fish shark = new Fish(new Point(0, 0), arr[0][0].dic);

        fun(arr, shark, 0);

        System.out.println(max);
    }

    private static void fun(Data[][] arr, Fish shark, int sum) {
        Data[][] copyArr = copyArray(arr);
        sum += copyArr[shark.point.y][shark.point.x].number;
        copyArr[shark.point.y][shark.point.x] = new Data(-1, -1);

        moveAllFish(copyArr, shark);

        List<Point> canMove = checkMove(copyArr, shark);
        if (canMove.size() == 0) {
            max = Math.max(max, sum);
            return;
        }

        for (Point p : canMove) {
            fun(copyArr, new Fish(p, copyArr[p.y][p.x].dic), sum);
        }
    }

    private static void moveAllFish(Data[][] copyArr, Fish shark) {
        for (int i = 1; i <= 16; i++) {
            Point p = findPoint(copyArr, i);
            if (p == null) {
                continue;
            }
            fishMove(copyArr, p, shark);
        }
    }

    private static Data[][] copyArray(Data[][] arr) {
        Data[][] copy = new Data[N][N];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = new Data(arr[i][j].number, arr[i][j].dic);
            }
        }
        return copy;
    }

    private static List<Point> checkMove(Data[][] arr, Fish shark) {
        List<Point> list = new ArrayList<>();
        int x = shark.point.x;
        int y = shark.point.y;
        while (true) {
            int nx = x + dx[shark.dic];
            int ny = y + dy[shark.dic];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            if (arr[ny][nx].number != -1) {
                list.add(new Point(nx, ny));
            }
            x = nx;
            y = ny;
        }
        return list;
    }

    private static void fishMove(Data[][] arr, Point p, Fish shark) {
        int x = p.x;
        int y = p.y;
        int dic = arr[y][x].dic;

        while (true) {
            int nx = x + dx[dic];
            int ny = y + dy[dic];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || (nx == shark.point.x && ny == shark.point.y)) {
                dic = (dic + 1) % 8;
                continue;
            }

            arr[y][x].dic = dic;
            Data tmp = arr[y][x];
            arr[y][x] = arr[ny][nx];
            arr[ny][nx] = tmp;
            break;
        }
    }

    private static Point findPoint(Data[][] arr, int target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].number == target) {
                    return new Point(j, i);
                }
            }
        }
        return null;
    }
}