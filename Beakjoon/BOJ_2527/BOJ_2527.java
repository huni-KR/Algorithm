package BOJ_2527;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2527 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static class Point {
        int x;
        int y;
        int index;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 4;

        for (int t = 1; t <= 4; t++) {
            List<Point> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            int[] xmin = new int[2], ymin = new int[2], xmax = new int[2], ymax = new int[2];
            for (int i = 0; i < 2; i++) {
                xmin[i] = Integer.parseInt(st.nextToken());
                ymin[i] = Integer.parseInt(st.nextToken());
                xmax[i] = Integer.parseInt(st.nextToken());
                ymax[i] = Integer.parseInt(st.nextToken());
                list.add(new Point(xmin[i], ymin[i], 1));
                list.add(new Point(xmax[i], ymax[i], 1));
            }
            list.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY).thenComparing(Point::getIndex));
        }

    }
}