package BOJ_2206;

import java.io.*;
import java.util.*;

public class BOJ_2206 {

    static int[][] arr;
    static boolean[][] visit;
    static int x, y;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[y][x];
        visit = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = (int) (str.charAt(j) - '0');
            }
        }

        System.out.println(BFS());
    }

    static class Data {
        int x;
        int y;
        int count;
        boolean flag;

        Data(int x, int y, int count, boolean flag) {
            this.x = x;
            this.y = y;
            this.count = 0;
            this.flag = flag;
        }
    }

    private static int BFS() {

        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, 0, 1, true));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Data data = queue.poll();

            if (data.x == x - 1 && data.y == y - 1) {
                return data.count;
            }

            for (int dic = 0; dic < 4; dic++) {
                int nx = data.x + dx[dic];
                int ny = data.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
                    continue;
                }

                if (!visit[ny][nx]) {

                    // if( )

                    queue.add(new Data(nx, ny, data.count + 1, true));
                } else {

                }
            }
        }
        return -1;
    }
}