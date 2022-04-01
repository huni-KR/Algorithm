package BOJ_1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

    static BufferedReader br;
    static StringTokenizer st;
    static int K, W, H, min;
    static int[][] arr;
    static boolean[][][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] hy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static class Data {
        int x, y, count, k;

        Data(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[H][W][K + 1];

        min = Integer.MAX_VALUE;
        min = BFS();

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int BFS() {
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, 0, 0, K));
        visit[0][0][K] = true;

        while (!queue.isEmpty()) {
            Data data = queue.poll();

            if (data.x == W - 1 && data.y == H - 1) {
                return data.count;
            }

            for (int dic = 0; dic < 4; dic++) {
                int nx = data.x + dx[dic];
                int ny = data.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                    continue;
                }

                if (arr[ny][nx] == 1) {
                    continue;
                }

                if (!visit[ny][nx][data.k]) {
                    visit[ny][nx][data.k] = true;
                    queue.add(new Data(nx, ny, data.count + 1, data.k));
                }
            }

            if (data.k > 0) {
                for (int dic = 0; dic < 8; dic++) {
                    int nx = data.x + hx[dic];
                    int ny = data.y + hy[dic];

                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                        continue;
                    }

                    if (arr[ny][nx] == 1) {
                        continue;
                    }

                    if (!visit[ny][nx][data.k - 1]) {
                        visit[ny][nx][data.k - 1] = true;
                        queue.add(new Data(nx, ny, data.count + 1, data.k - 1));
                    }
                }
            }
        }
        return min;
    }
}