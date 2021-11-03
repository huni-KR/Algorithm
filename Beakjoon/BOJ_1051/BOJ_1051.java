package BOJ_1051;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}

public class BOJ_1051 {

    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[][] arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        List[] list = new ArrayList[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Point>();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                list[arr[i][j]].add(new Point(j, i));
            }
        }

        for (int i = 0; i < list.length; i++) {
            list[i].sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        }

        System.out.println(find(list));
    }

    private static int find(List[] list) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].size() >= 4 && isSquare(list[i]) > 0) {

            }
        }

        return 0;
    }

    private static int isSquare(List list) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Point[] point = new Point[4];
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    for (int l = k + 1; l < list.size(); l++) {
                        map = new HashMap<>();

                        point[0] = (Point) list.get(i);
                        point[1] = (Point) list.get(j);
                        point[2] = (Point) list.get(k);
                        point[3] = (Point) list.get(l);

                        for (int m = 0; m < point.length; m++) {
                            if (map.containsKey(point[m].x)) {
                                map.put(point[m].x, map.get(point[m].x) + 1);
                            } else {
                                map.put(point[m].x, 1);
                            }
                            if (map.containsKey(point[m].y)) {
                                map.put(point[m].y, map.get(point[m].y) + 1);
                            } else {
                                map.put(point[m].y, 1);
                            }
                        }
                        int result = checkMap(map);
                        if (map.size() == 3 && result > 0) {
                            return result;
                        }

                        System.out.println();
                    }
                }
            }
        }
        return -1;
    }

    private static boolean checkMap(HashMap<Integer, Integer> map) {

        int[] arr = new int[2];

        for (int i : map.values()) {
            if (i == 2) {
                arr[0]++;
            } else if (i == 4) {
                arr[1]++;
            }
        }

        if (arr[0] == 2 && arr[1] == 1) {
            return true;
        }
        return false;
    }

}
