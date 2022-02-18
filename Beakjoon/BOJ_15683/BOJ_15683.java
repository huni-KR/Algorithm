package BOJ_15683;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, min;
    static int[][] arr;
    static boolean[] check;
    static List<Point> points;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

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
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0 && arr[i][j] < 6) {
                    points.add(new Point(j, i));
                }
            }
        }

        check = new boolean[points.size()];
        min = Integer.MAX_VALUE;
        fun(0); // 완전 탐색
        System.out.println(min);
    }

    private static void fun(int pos) {

        // 모든 감시탑 방문하였을때 감시 불가 지역 최소값 저장
        if (pos == points.size()) {
            // sumNotVisited 방문하지 않은 지역수
            min = Math.min(min, sumNotVisited());
        }

        for (int i = pos; i < points.size(); i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            // CCTV 4방향 회전
            for (int dic = 0; dic < 4; dic++) {
                // 감시 가능한 지역 지역 위치 +100
                painting(points.get(i), dic, 100);
                // 재귀 호출
                fun(pos + 1);
                // 감시 가능한 지역 확인 후 가중치 다시 감소
                painting(points.get(i), dic, -100);
            }
            check[i] = false;
        }
    }

    private static void painting(Point point, int dic, int flag) {
        // CCTV 형태 1~5 / CCTV 방향 0~3에 따라 감시 가능한 위치
        List<Integer> ways = new ArrayList<>();
        if (arr[point.y][point.x] % 100 == 1) {
            if (dic == 0) {
                ways.add(1);
            } else if (dic == 1) {
                ways.add(2);
            } else if (dic == 2) {
                ways.add(3);
            } else if (dic == 3) {
                ways.add(0);
            }
        } else if (arr[point.y][point.x] % 100 == 2) {
            if (dic == 0 || dic == 2) {
                ways.add(1);
                ways.add(3);
            } else if (dic == 1 || dic == 3) {
                ways.add(0);
                ways.add(2);
            }
        } else if (arr[point.y][point.x] % 100 == 3) {
            if (dic == 0) {
                ways.add(0);
                ways.add(1);
            } else if (dic == 1) {
                ways.add(1);
                ways.add(2);
            } else if (dic == 2) {
                ways.add(2);
                ways.add(3);
            } else if (dic == 3) {
                ways.add(3);
                ways.add(0);
            }
        } else if (arr[point.y][point.x] % 100 == 4) {
            if (dic == 0) {
                ways.add(0);
                ways.add(1);
                ways.add(3);
            } else if (dic == 1) {
                ways.add(0);
                ways.add(1);
                ways.add(2);
            } else if (dic == 2) {
                ways.add(1);
                ways.add(2);
                ways.add(3);
            } else if (dic == 3) {
                ways.add(0);
                ways.add(2);
                ways.add(3);
            }
        } else if (arr[point.y][point.x] % 100 == 5) {
            ways.add(0);
            ways.add(1);
            ways.add(2);
            ways.add(3);
        }
        // CCTV 형태 및 방향에 따라 감시 가능 지역 값 변경
        for (int w : ways) {
            paint(point, w, flag);
        }
    }

    private static void paint(Point point, int w, int flag) {
        int x = point.x;
        int y = point.y;
        while (true) {
            int nx = x + dx[w];
            int ny = y + dy[w];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                break;
            }

            if (arr[ny][nx] == 6) {
                break;
            }

            arr[ny][nx] += flag;
            x = nx;
            y = ny;
        }
    }

    private static int sumNotVisited() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}