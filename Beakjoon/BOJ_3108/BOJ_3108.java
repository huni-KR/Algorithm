package BOJ_3108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_3108 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    // x1 y1 x2 y2
    static int[][] arr;
    static int[][] map;
    static int[] p;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][4];
        map = new int[1001][1001];

        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }

        // 방문하지 않은 지도 초기화
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }

        // 시작점 (0,0) 초기화
        map[500][500] = 0;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 500;
            }
            draw(i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            set.add(p[i]);
        }

        System.out.println(set.size() - 1);

    }

    private static void draw(int pos) {

        // 해당 사각형이 다른 사각형과 겹치는지 판별
        // union find 사용
        check(pos, arr[pos][0], arr[pos][2], arr[pos][1], arr[pos][3]);

        // 
        paint(pos, arr[pos][0], arr[pos][2], arr[pos][1], arr[pos][3]);
    }

    private static void check(int pos, int x1, int x2, int y1, int y2) {

        for (int i = x1; i <= x2; i++) {
            if (map[y1][i] != -1) {
                union(map[y1][i], pos);
            }
        }

        for (int i = x1; i <= x2; i++) {
            if (map[y2][i] != -1) {
                union(map[y2][i], pos);
            }
        }

        for (int i = y1; i <= y2; i++) {
            if (map[i][x1] != -1) {
                union(map[i][x1], pos);
            }
        }

        for (int i = y1; i <= y2; i++) {
            if (map[i][x2] != -1) {
                union(map[i][x2], pos);
            }
        }
    }

    private static void paint(int pos, int x1, int x2, int y1, int y2) {

        for (int i = x1; i <= x2; i++) {
            if (map[y1][i] == -1) {
                map[y1][i] = pos;
            }
        }

        for (int i = x1; i <= x2; i++) {
            if (map[y2][i] == -1) {
                map[y2][i] = pos;
            }
        }

        for (int i = y1; i <= y2; i++) {
            if (map[i][x1] == -1) {
                map[i][x1] = pos;
            }
        }

        for (int i = y1; i <= y2; i++) {
            if (map[i][x2] == -1) {
                map[i][x2] = pos;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[b] = a;
        }
    }

    private static int find(int pos) {
        if (p[pos] == pos) {
            return pos;
        }
        return p[pos] = find(p[pos]);
    }
}