package SW2805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SW2805 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = init(n);
            bw.write("#");
            bw.write(Integer.toString(t + 1));
            bw.write(" ");
            bw.write(Integer.toString(BFS(arr, n / 2)));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int BFS(int[][] arr, int depth) {

        boolean[][] visit = new boolean[arr.length][arr.length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(depth, depth));
        visit[depth][depth] = true;
        int sum = arr[depth][depth];
        for (int i = 0; i < depth; i++) {
            int qsize = queue.size();
            for (int j = 0; j < qsize; j++) {
                Point p = queue.poll();

                for (int dic = 0; dic < 4; dic++) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) {
                        return sum;
                    }

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        sum += arr[ny][nx];
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return sum;
    }

    private static int[][] init(int n) throws IOException {
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        return arr;
    }
}