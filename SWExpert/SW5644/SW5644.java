package SW5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SW5644 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] arr;
    static int M, A;
    static Person[] people;
    static Battery[] batteries;
    static int sum;
    static int[] dx = { 0, 0, 1, 0, -1 };
    static int[] dy = { 0, -1, 0, 1, 0 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Person {
        Point point;
        List<Integer> batteryCenter;

        Person(Point point) {
            this.point = point;
            this.batteryCenter = new ArrayList<>();
        }
    }

    static class Battery {
        Point point;
        int C;
        int P;

        Battery(Point point, int C, int P) {
            this.point = point;
            this.C = C;
            this.P = P;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            arr = new int[2][M];
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            people = new Person[] { new Person(new Point(0, 0)), new Person(new Point(9, 9)) };

            batteries = new Battery[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                batteries[i] = new Battery(new Point(x, y), C, P);
            }

            sum = 0;
            fun();
            bw.write("#" + Integer.toString(t) + " " + Integer.toString(sum) + "\n");
        }
        bw.flush();
    }

    private static void fun() {
        for (int T = 0; T <= M; T++) {
            for (int i = 0; i < people.length; i++) {
                isArea(people[i], i);
            }

            int max = 0;
            if (people[0].batteryCenter.size() > 0 && people[1].batteryCenter.size() > 0) {
                for (int i : people[0].batteryCenter) {
                    for (int j : people[1].batteryCenter) {
                        if (i == j) {
                            max = Math.max(max, batteries[i].P);
                        } else {
                            max = Math.max(max, batteries[i].P + batteries[j].P);
                        }
                    }
                }
            } else if (people[0].batteryCenter.size() > 0) {
                for (int i : people[0].batteryCenter) {
                    max = Math.max(max, batteries[i].P);
                }
            } else if (people[1].batteryCenter.size() > 0) {
                for (int i : people[1].batteryCenter) {
                    max = Math.max(max, batteries[i].P);
                }
            }

            sum += max;

            if (T == M) {
                break;
            }

            // move
            people[0].point.x += dx[arr[0][T]];
            people[0].point.y += dy[arr[0][T]];
            people[1].point.x += dx[arr[1][T]];
            people[1].point.y += dy[arr[1][T]];
        }

    }

    private static void isArea(Person person, int pos) {
        person.batteryCenter.clear();

        for (int i = 0; i < batteries.length; i++) {
            int dist = Math.abs(batteries[i].point.x - person.point.x)
                    + Math.abs(batteries[i].point.y - person.point.y);
            if (dist <= batteries[i].C) {
                person.batteryCenter.add(i);
            }
        }
    }
}