package Lv2;

import java.util.*;

class CheckDistance {

    public static void main(String[] args) {

        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        Solution s = new Solution();
        int[] arr = s.solution(places);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            for (int i = 0; i < places.length; i++) {
                answer[i] = fun(places[i]);
            }
            return answer;
        }

        private int fun(String[] strings) {
            char[][] arr = new char[strings.length][strings[0].length()];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = strings[i].charAt(j);
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 'P' && !checkManhattan(arr, i, j)) {
                        return 0;
                    }
                }
            }

            return 1;
        }

        private boolean checkManhattan(char[][] arr, int ty, int tx) {

            int[] dx = { 0, 1, 0, -1 };
            int[] dy = { -1, 0, 1, 0 };
            int distance = 0;

            boolean[][] visit = new boolean[arr.length][arr[0].length];
            Queue<Point> queue = new LinkedList<Point>();

            visit[ty][tx] = true;
            queue.add(new Point(tx, ty));

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                distance++;
                if (distance == 3) {
                    break;
                }
                for (int dic = 0; dic < 4; dic++) {
                    int nx = point.x + dx[dic];
                    int ny = point.y + dy[dic];

                    if (nx < 0 || ny < 0 || ny >= arr.length || nx >= arr[0].length) {
                        continue;
                    }

                    if (arr[ny][nx] == 'P' && !visit[ny][nx]) {
                        return false;
                    } else if (arr[ny][nx] == 'X') {
                        continue;
                    } else if (arr[ny][nx] == 'O' && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            return true;
        }
    }
}