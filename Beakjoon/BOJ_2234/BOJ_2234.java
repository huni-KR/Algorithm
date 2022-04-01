package BOJ_2234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static Data[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[] answer = new int[3];

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Data {
        boolean[] data;

        Data(boolean[] data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Data[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = new Data(getWallData(Integer.parseInt(st.nextToken())));
            }
        }

        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    answer[1] = Math.max(answer[1], BFS(j, i));
                    answer[0]++;
                }
            }
        }

        for (int dic = 0; dic < 4; dic++) {
            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (arr[a][b].data[dic]) {
                        visit = new boolean[M][N];
                        arr[a][b].data[dic] = false;
                        answer[2] = Math.max(answer[2], BFS(b, a));
                        arr[a][b].data[dic] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }

    }

    public static boolean[] getWallData(int current) {
        boolean[] isWall = new boolean[4]; // 남, 동, 북, 서

        int i = isWall.length - 1;
        while (current / 2 != 0) {
            int a = current % 2;

            if (a == 1) { // 벽일 때
                isWall[i] = true;
            }

            current = current / 2;
            i--;
        }

        if (current % 2 == 1) {
            isWall[i] = true;
        }

        return isWall;
    }

    private static int BFS(int x, int y) {
        int count = 0;
        visit[y][x] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {

            Point p = queue.poll();
            count++;
            for (int dic = 0; dic < 4; dic++) {
                if (!arr[p.y][p.x].data[dic]) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return count;
    }
}