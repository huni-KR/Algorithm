package BOJ_15686;

import java.io.*;
import java.util.*;

public class BOJ_15686 {

    static int N, M, min;
    static int[] dist;
    static boolean[] visit;
    static List<Pos> house, chicken;

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    house.add(new Pos(j, i));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Pos(j, i));
                }
            }
        }

        min = Integer.MAX_VALUE;
        dist = new int[house.size()];

        visit = new boolean[chicken.size()];
        fun(0, 0);
        System.out.println(min);
    }

    private static void fun(int detph, int pos) {
        if (detph == M) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            int sum = 0;
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    for (int j = 0; j < dist.length; j++) {
                        dist[j] = Math.min(dist[j], calc(i, j));
                    }
                }
            }

            for (int i = 0; i < dist.length; i++) {
                sum += dist[i];
            }

            min = Math.min(min, sum);
            return;
        }
        for (int i = pos; i < visit.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            fun(detph + 1, i + 1);
            visit[i] = false;
        }
    }

    private static int calc(int c, int h) {
        return Math.abs(house.get(h).x - chicken.get(c).x) + Math.abs(house.get(h).y - chicken.get(c).y);
    }
}
