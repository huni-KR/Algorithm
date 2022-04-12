package BOJ_1708;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1708 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static List<Point> list;

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            list.add(new Point(x, y));
        }

        // 기준점 정렬
        list.sort(Comparator.comparing(Point::getY).thenComparing(Point::getX));

        Point first = list.get(0);

        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point second, Point third) {
                int ccwR = ccw(first, second, third);
                if (ccwR > 0) {
                    return -1;
                } else if (ccwR < 0) {
                    return 1;
                } else if (ccwR == 0) {
                    long distR1 = dist(first, second);
                    long distR2 = dist(first, third);
                    if (distR1 > distR2) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        // stack 활용해서 데이터 검증
        Stack<Point> stack = new Stack<>();
        stack.add(first);
        for (int i = 1; i < list.size(); i++) {
            // ccw로 좌회전 판별
            while (stack.size() > 1
                    && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), list.get(i)) <= 0)) {
                stack.pop();
            }
            stack.push(list.get(i));
        }

        System.out.println(stack.size());
    }

    static long dist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);

        if (result > 0) { // 반시계 방향
            return 1;
        } else if (result < 0) { // 시계 방향
            return -1;
        } else {
            return 0;
        }
    }
}

// 1. 기준점 잡기 => y축 좌표 작은거
// 2. 각에 따라 반 시계 방향으로 정렬
// 3. 그라함 스캔 알고리즘

// https://kbw1101.tistory.com/50
// https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-4181-Convex-Hull-java