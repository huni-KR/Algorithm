package BOJ_4485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int[][] arr, visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Data {
        int value;
        Point point;

        Data(int value, Point point) {
            this.value = value;
            this.point = point;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        int count = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(visit[i], Integer.MAX_VALUE);
            }
            PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(Data::getValue));
            pq.offer(new Data(arr[0][0], new Point(0, 0)));
            visit[0][0] = arr[0][0];

            while (!pq.isEmpty()) {
                Data data = pq.poll();
                for (int dic = 0; dic < 4; dic++) {
                    int nx = data.point.x + dx[dic];
                    int ny = data.point.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (visit[ny][nx] > data.value + arr[ny][nx]) {
                        visit[ny][nx] = data.value + arr[ny][nx];
                        pq.offer(new Data(data.value + arr[ny][nx], new Point(nx, ny)));
                    }
                }
            }

            sb.append("Problem ");
            sb.append(Integer.toString(count++));
            sb.append(": ");
            sb.append(Integer.toString(visit[N - 1][N - 1]));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
