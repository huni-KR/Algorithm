package SW1767;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class SW1767 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N;
    static int[][] arr;
    static int[] visit;
    static Map<Integer, Integer> map;
    static List<Point> list;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            list = new ArrayList<>();

            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {

                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                        continue;
                    }
                    if (arr[i][j] == 1) {
                        list.add(new Point(j, i));
                    }

                }
            }

            map = new HashMap<>();
            dfs(0, 0, 0);

            int result = getResult();

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(result));
            bw.write("\n");
        }
        bw.flush();

    }

    private static int getResult() {
        Set<Integer> keySet = map.keySet();
        int max = 0;
        for (int i : keySet) {
            max = Math.max(max, i);
        }
        return map.get(max);
    }

    private static void dfs(int index, int core, int wire) {
        if (index == list.size()) {
            if (!map.containsKey(core)) {
                map.put(core, wire);
            } else {
                int tmp = map.get(core);
                map.put(core, Math.min(wire, tmp));
            }
            return;
        }

        Point point = list.get(index);
        for (int dic = 0; dic < 4; dic++) {
            int distance = getDistance(point, dic);
            mark(index, 1, dic, distance);
            if (distance == 0) {
                dfs(index + 1, core, wire);
            } else {
                dfs(index + 1, core + 1, wire + distance);
                mark(index, 0, dic, distance);
            }
        }
    }

    private static void mark(int index, int value, int dic, int distance) {
        Point point = list.get(index);
        int nx = point.x;
        int ny = point.y;
        for (int i = 0; i < distance; i++) {
            nx += dx[dic];
            ny += dy[dic];
            arr[ny][nx] = value;
        }
    }

    private static int getDistance(Point point, int dic) {
        int nx = point.x;
        int ny = point.y;
        int count = 0;
        while (true) {
            nx += dx[dic];
            ny += dy[dic];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                return count;
            }
            if (arr[ny][nx] != 0) {
                return 0;
            }
            count++;
        }
    }
}
// 4방향 dfs
// param : 2차원 배열 / point
// 뻗을 수 있으면 그리기
// 아니면 그리지않기