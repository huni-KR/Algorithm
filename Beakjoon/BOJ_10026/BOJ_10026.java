package BOJ_10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][][] arr;
    static boolean[][] visit;
    static int N, result1, result2;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j][0] = str.charAt(j);
                if (arr[i][j][0] == 'G') {
                    arr[i][j][1] = 'R';
                } else {
                    arr[i][j][1] = arr[i][j][0];
                }
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    BFS(j, i, 0);
                    result1++;
                }
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    BFS(j, i, 1);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    private static void BFS(int x, int y, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int dic = 0; dic < 4; dic++) {
                int nx = pos[0] + dx[dic];
                int ny = pos[1] + dy[dic];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (!visit[ny][nx] && arr[pos[1]][pos[0]][h] == arr[ny][nx][h]) {
                    visit[ny][nx] = true;
                    queue.add(new int[] { nx, ny });
                }
            }
        }
    }
}
