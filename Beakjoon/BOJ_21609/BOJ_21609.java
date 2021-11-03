package BOJ_21609;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_21609 {

    static int n, m;
    static int[][][] arr;
    static int[][] score;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n][2];
        score = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            BFS();
        }

    }

    private static void BFS() {

        Queue<Point> queue = new LinkedList<>();

        while (!queue.isEmpty()) {

        }

    }
}