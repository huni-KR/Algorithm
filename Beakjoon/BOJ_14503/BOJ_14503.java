package BOJ_14503;

import java.io.*;
import java.util.*;

public class BOJ_14503 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Robot {
        Point p;
        int dic;

        Robot(Point p, int dic) {
            this.p = p;
            this.dic = dic;
        }
    }

    static int x, y, count;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static Robot robot;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];

        st = new StringTokenizer(br.readLine(), " ");
        int tmpY = Integer.parseInt(st.nextToken());
        int tmpX = Integer.parseInt(st.nextToken());
        robot = new Robot(new Point(tmpX, tmpY), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        visit = new boolean[y][x];
        move();
        System.out.println(count);
    }

    private static void move() {
        int check = 0;
        while (true) {
            if (!visit[robot.p.y][robot.p.x]) {
                visit[robot.p.y][robot.p.x] = true;
                count++;
            }

            if (check == 4) {
                if (arr[robot.p.y - dy[robot.dic]][robot.p.x - dx[robot.dic]] == 1) {
                    break;
                }
                robot.p.x -= dx[robot.dic];
                robot.p.y -= dy[robot.dic];
                check = 0;
                continue;
            }

            int tDic = robot.dic - 1;
            if (tDic < 0) {
                tDic += 4;
            }

            if (arr[robot.p.y + dy[tDic]][robot.p.x + dx[tDic]] == 0
                    && !visit[robot.p.y + dy[tDic]][robot.p.x + dx[tDic]]) {
                robot.p.x += dx[tDic];
                robot.p.y += dy[tDic];
                check = 0;
            } else {
                check++;
            }
            robot.dic = tDic;
        }
    }
}
