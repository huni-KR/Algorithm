package BOJ_13903;

import java.io.*;
import java.util.*;

public class BOJ_13903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = Integer.parseInt(br.readLine());
        int[][] dic = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                dic[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = Math.max(x, y);
        List<Integer>[] list = new ArrayList[tmp];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < dic.length; k++) {
                        if (i + dic[k][0] < 0 || j + dic[k][1] < 0 || i + dic[k][0] >= y || j + dic[k][1] >= x) {
                            continue;
                        }

                        if (arr[i + dic[k][0]][j + dic[k][1]] == 1) {
                            if (!list[i].contains(j))
                                list[i].add(j);
                            if (!list[j].contains(i))
                                list[j].add(i);
                        }
                    }

                }
            }
        }

        System.out.println(11);
    }
}

// class Data {
// int x;
// int y;

// Data(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// public class BOJ_13903 {

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine(), " ");

// int y = Integer.parseInt(st.nextToken());
// int x = Integer.parseInt(st.nextToken());

// int[][] arr = new int[y][x];
// for (int i = 0; i < y; i++) {
// st = new StringTokenizer(br.readLine(), " ");
// for (int j = 0; j < x; j++) {
// arr[i][j] = Integer.parseInt(st.nextToken());
// }
// }

// int n = Integer.parseInt(br.readLine());

// int[][] dic = new int[n][2];
// for (int i = 0; i < n; i++) {
// st = new StringTokenizer(br.readLine(), " ");
// for (int j = 0; j < 2; j++) {
// dic[i][j] = Integer.parseInt(st.nextToken());
// }
// }

// List<Integer> list = new ArrayList<>();
// for (int i = 0; i < x; i++) {
// if (arr[0][i] == 1) {
// list.add(fun(arr, dic, new Data(i, 0)));
// }
// }
// System.out.println(findMin(list));
// }

// private static int findMin(List<Integer> list) {
// int min = Integer.MAX_VALUE;
// for (int i : list) {
// min = Math.min(min, i);
// }

// if (min == Integer.MAX_VALUE) {
// return -1;
// }

// return min;
// }

// private static int fun(int[][] arr, int[][] dic, Data pos) {

// int[][] visit = new int[arr.length][arr[0].length];
// for (int i = 0; i < visit.length; i++) {
// Arrays.fill(visit[i], Integer.MAX_VALUE);
// }
// visit[pos.y][pos.x] = 0;

// Queue<Data> queue = new LinkedList<>();
// queue.add(pos);

// while (!queue.isEmpty()) {
// int qSize = queue.size();
// for (int i = 0; i < qSize; i++) {
// Data data = queue.poll();
// int x = data.x;
// int y = data.y;
// for (int d = 0; d < dic.length; d++) {
// int nX = x + dic[d][1];
// int nY = y + dic[d][0];

// if (nX < 0 || nY < 0 || nX >= arr[0].length || nY >= arr.length) {
// continue;
// }

// if (arr[nY][nX] == 1 && visit[nY][nX] > visit[y][x] + 1) {
// visit[nY][nX] = visit[y][x] + 1;
// queue.add(new Data(nX, nY));

// if (nY == arr.length - 1)
// return visit[nY][nX];
// }
// }
// }
// }

// int min = Integer.MAX_VALUE;
// for (int i = 0; i < arr[0].length; i++) {
// min = Math.min(min, visit[arr.length - 1][i]);
// }

// return min;
// }
// }
