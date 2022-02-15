package BOJ_2578;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2578 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

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
        int n = 5;
        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                map.put(value, new Point(j, i));
            }
        }

        boolean[][] visit = new boolean[n][n];
        int cnt = 1;
        for (int i = 0; i < visit.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < visit.length; j++) {
                int call = Integer.parseInt(st.nextToken());
                visit[map.get(call).y][map.get(call).x] = true;
                if (bingoCount(visit) >= 3) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
        }
    }

    private static int bingoCount(boolean[][] visit) {
        int count = 0;

        // 대각 좌상 -> 우하
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i][i]) {
                break;
            }
            if (i == visit.length - 1) {
                count++;
            }
        }

        // 대각 우상 -> 좌하
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i][visit.length - i - 1]) {
                break;
            }
            if (i == visit.length - 1) {
                count++;
            }
        }

        for (int i = 0; i < visit.length; i++) {
            // 가로 좌 -> 우
            for (int j = 0; j < visit.length; j++) {
                if (!visit[i][j]) {
                    break;
                }
                if (j == visit.length - 1) {
                    count++;
                }
            }
            // 세로 상 -> 하
            for (int j = 0; j < visit.length; j++) {
                if (!visit[j][i]) {
                    break;
                }
                if (j == visit.length - 1) {
                    count++;
                }
            }
        }
        return count;
    }
}