package BOJ_17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int N, M, K;
    static int[][] arr, fun;
    static int[] dx, dy;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dx = new int[] { 1, 0, -1, 0 };
        dy = new int[] { 0, 1, 0, -1 };

        arr = new int[N + 1][M + 1];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fun = new int[K][3];
        visit = new boolean[K];
        for (int i = 0; i < fun.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < fun[0].length; j++) {
                fun[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        permu(new ArrayList<>());

        System.out.println(min);
    }

    private static void permu(ArrayList<Integer> arrayList) {
        if (arrayList.size() == K) {
            int[][] copy = new int[arr.length][arr[0].length];
            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = arr[i][j];
                }
            }

            for (int pos : arrayList) {
                copy = move(copy, pos);
            }
            min = Math.min(min, sum(copy));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            arrayList.add(i);
            permu(arrayList);
            arrayList.remove(arrayList.size() - 1);
            visit[i] = false;
        }
    }

    private static int sum(int[][] copy) {
        int miniMin = Integer.MAX_VALUE;

        for (int i = 1; i < copy.length; i++) {
            int sum = 0;
            for (int j = 0; j < copy[0].length; j++) {
                sum += copy[i][j];
            }
            miniMin = Math.min(miniMin, sum);
        }
        return miniMin;
    }

    private static int[][] move(int[][] copy, int pos) {

        int sy = fun[pos][0] - fun[pos][2];
        int sx = fun[pos][1] - fun[pos][2];
        int ey = fun[pos][0] + fun[pos][2];
        int ex = fun[pos][1] + fun[pos][2];

        int[][] newArray = new int[ey - sy + 1][ex - sx + 1];
        for (int i = sy; i <= ey; i++) {
            for (int j = sx; j <= ex; j++) {
                newArray[i - sy][j - sx] = copy[i][j];
            }
        }

        newArray = round(newArray);

        for (int i = sy; i <= ey; i++) {
            for (int j = sx; j <= ex; j++) {
                copy[i][j] = newArray[i - sy][j - sx];
            }
        }

        return copy;
    }

    private static int[][] round(int[][] newArray) {
        int[][] tmp = new int[newArray.length][newArray[0].length];

        for (int i = 0; i < tmp.length; i++) {
            Arrays.fill(tmp[i], -1);
        }

        int sx = 0, sy = 0, nx = 0, ny = 0, lx = 0, ly = 0, dic = 0, level = 0;

        while (tmp[sy][sx] == -1) {

            while (true) {

                nx = lx + dx[dic];
                ny = ly + dy[dic];
                if (nx < level || ny < level || nx >= tmp[0].length - level || ny >= tmp.length - level) {
                    nx -= dx[dic];
                    ny -= dy[dic];
                    break;
                }

                tmp[ny][nx] = newArray[ly][lx];

                lx = nx;
                ly = ny;
            }
            if (nx == sx && ny == sy) {
                sx++;
                sy++;
                lx++;
                ly++;
                level++;
            }
            dic = (dic + 1) % 4;

        }

        tmp[ny][nx] = newArray[ny][nx];
        return tmp;
    }
}