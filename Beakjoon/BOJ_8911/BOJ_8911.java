package BOJ_8911;

import java.io.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Turtle {
    Point point;
    int dic;

    Turtle(Point p, int d) {
        this.point = p;
        this.dic = d;
    }
}

public class BOJ_8911 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int c = 0; c < n; c++) {
            String str = br.readLine();
            Turtle turtle = new Turtle(new Point(0, 0), 1000);

            bw.write(fun(str, turtle) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String fun(String str, Turtle turtle) {

        // 0:minX 1:maxX 2:minY 3:maxY
        int[] arr = new int[4];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'F') {
                if (turtle.dic % 4 == 0) {
                    turtle.point.y--;
                } else if (turtle.dic % 4 == 1) {
                    turtle.point.x++;
                } else if (turtle.dic % 4 == 2) {
                    turtle.point.y++;
                } else if (turtle.dic % 4 == 3) {
                    turtle.point.x--;
                }
            } else if (c == 'R') {
                turtle.dic++;
            } else if (c == 'L') {
                turtle.dic--;
            } else if (c == 'B') {
                if (turtle.dic % 4 == 0) {
                    turtle.point.y++;
                } else if (turtle.dic % 4 == 1) {
                    turtle.point.x--;
                } else if (turtle.dic % 4 == 2) {
                    turtle.point.y--;
                } else if (turtle.dic % 4 == 3) {
                    turtle.point.x++;
                }
            }
            arr[0] = Math.min(arr[0], turtle.point.x);
            arr[1] = Math.max(arr[1], turtle.point.x);
            arr[2] = Math.min(arr[2], turtle.point.y);
            arr[3] = Math.max(arr[3], turtle.point.y);
        }

        return Integer.toString((arr[1] - arr[0]) * (arr[3] - arr[2]));
    }
}
