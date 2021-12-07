package BOJ_2933;

import java.io.*;
import java.util.*;

public class BOJ_2933 {

    static boolean[][] visit;
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        visit = new boolean[arr.length][arr[0].length];
        list = new ArrayList<>();

        boolean isRight = true;
        while (st.hasMoreTokens()) {
            int high = r - Integer.parseInt(st.nextToken());
            throwStick(arr, high, isRight);

            for (int i = 0; i < 3; i++) {
                if (checkFly(arr)) {
                    int dist = findDistance(arr);
                    move(arr, dist);
                }
            }

            isRight = !isRight;

            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(visit[i], false);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void move(char[][] arr, int dist) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                if (list.contains(new Point(j, i))) {
                    arr[i + dist][j] = 'x';
                    visit[i + dist][j] = true;
                    arr[i][j] = '.';
                }
            }
        }
    }

    private static int findDistance(char[][] arr) {
        HashMap<Integer, Integer> map = makeMaxMap(arr);

        int dist = 1;
        while (true) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (value + dist == arr.length) {
                    return dist - 1;
                }
                if (arr[value + dist][key] == 'x') {
                    return dist - 1;
                }

            }
            dist++;
        }
    }

    private static HashMap<Integer, Integer> makeMaxMap(char[][] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Point p : list) {
            if (map.containsKey(p.x)) {
                map.replace(p.x, Math.max(map.get(p.x), p.y));
            } else {
                map.put(p.x, p.y);
            }
        }
        return map;
    }

    private static boolean checkFly(char[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'x' && !visit[i][j]) {
                    list = BFS(arr, j, i);
                    return findMaxInList(list) == arr.length - 1 ? false : true;
                }
            }
        }
        return false;
    }

    private static int findMaxInList(ArrayList<Point> list) {
        int max = 0;
        for (Point p : list) {
            max = Math.max(p.y, max);
        }
        return max;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            return this.x == ((Point) object).x && this.y == ((Point) object).y;
        }
    }

    private static ArrayList<Point> BFS(char[][] arr, int x, int y) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        visit[y][x] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        ArrayList<Point> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            list.add(point);

            for (int dic = 0; dic < 4; dic++) {
                int nx = point.x + dx[dic];
                int ny = point.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= arr[0].length || ny >= arr.length) {
                    continue;
                }

                if (!visit[ny][nx] && arr[ny][nx] == 'x') {
                    visit[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }

            }
        }
        return list;
    }

    private static void throwStick(char[][] arr, int high, boolean isRight) {
        if (isRight) {
            int start = 0;
            for (int i = start; i < arr[0].length; i++) {
                if (arr[high][i] == 'x') {
                    arr[high][i] = '.';
                    return;
                }
            }
        } else {
            int start = arr[0].length - 1;
            for (int i = start; i >= 0; i--) {
                if (arr[high][i] == 'x') {
                    arr[high][i] = '.';
                    return;
                }
            }
        }
    }
}
