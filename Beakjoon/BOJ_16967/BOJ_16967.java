package BOJ_16967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16967 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int H, W, X, Y;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H + X][W + Y];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visit = new int[H + X][W + Y];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                visit[i][j]++;
            }
        }
        for (int i = X; i < H + X; i++) {
            for (int j = Y; j < W + Y; j++) {
                visit[i][j]++;
            }
        }

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[i].length; j++) {
                if (visit[i][j] == 2) {
                    minX = Math.min(minX, j);
                    minY = Math.min(minY, i);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                arr[i][j] -= arr[i - X][j - Y];
            }
        }
        print(arr, 0, 0, H, W);
    }

    private static void print(int[][] arr, int y1, int x1, int y2, int x2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}