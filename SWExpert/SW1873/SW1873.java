package SW1873;

import java.io.*;
import java.util.*;

public class SW1873 {

    static final char LAND = '.';
    static final char ROCKWALL = '*';
    static final char STEELWALL = '#';
    static final char WATER = '-';
    static final char UP = '^';
    static final char DOWN = 'v';
    static final char LEFT = '<';
    static final char RIGHT = '>';

    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;

    static char[][] arr;
    static int sy, sx;
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

    static class Tank {
        Point point;
        int dic;

        Tank(Point p, int d) {
            this.point = p;
            this.dic = d;
        }

        void move(char[][] arr, int dic) {
            this.dic = dic;
            int nx = this.point.x + dx[dic];
            int ny = this.point.y + dy[dic];

            if (nx < 0 || ny < 0 || nx >= sx || ny >= sy || arr[ny][nx] != LAND) {
                setDic(dic);
                return;
            }

            arr[this.point.y][this.point.x] = LAND;
            this.point.x = nx;
            this.point.y = ny;

            setDic(dic);
        }

        private void setDic(int dic2) {
            if (dic2 == 0) {
                arr[this.point.y][this.point.x] = UP;
            } else if (dic2 == 1) {
                arr[this.point.y][this.point.x] = RIGHT;
            } else if (dic2 == 2) {
                arr[this.point.y][this.point.x] = DOWN;
            } else if (dic2 == 3) {
                arr[this.point.y][this.point.x] = LEFT;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());

            arr = new char[sy][sx];
            Tank tank = null;
            for (int i = 0; i < sy; i++) {
                String str = br.readLine();
                for (int j = 0; j < sx; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == UP) {
                        tank = new Tank(new Point(j, i), 0);
                    } else if (arr[i][j] == RIGHT) {
                        tank = new Tank(new Point(j, i), 1);
                    } else if (arr[i][j] == DOWN) {
                        tank = new Tank(new Point(j, i), 2);
                    } else if (arr[i][j] == LEFT) {
                        tank = new Tank(new Point(j, i), 3);
                    }
                }
            }

            br.readLine();
            String order = br.readLine();

            bw.write("#" + Integer.toString(t + 1) + " ");
            handleTank(tank, order);
            printArray(t);
            bw.write(sb.toString());
        }
        bw.flush();
    }

    private static void handleTank(Tank tank, String order) {
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (c == 'U') {
                tank.move(arr, 0);
            } else if (c == 'R') {
                tank.move(arr, 1);
            } else if (c == 'D') {
                tank.move(arr, 2);
            } else if (c == 'L') {
                tank.move(arr, 3);
            } else if (c == 'S') {
                shoot(tank);
            }
        }
    }

    private static void shoot(Tank tank) {
        int dic = tank.dic;

        int nx = tank.point.x + dx[dic];
        int ny = tank.point.y + dy[dic];

        while (true) {
            if (nx < 0 || ny < 0 || nx >= sx || ny >= sy || arr[ny][nx] == STEELWALL) {
                return;
            }

            if (arr[ny][nx] == ROCKWALL) {
                arr[ny][nx] = LAND;
                break;
            }

            nx += dx[dic];
            ny += dy[dic];
        }
    }

    private static void printArray(int t) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
    }
}
