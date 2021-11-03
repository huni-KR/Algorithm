// import java.util.*;

// public class P02 {

// public static void main(String[] args) {
// Solution s = new Solution();

// s.solution();
// }
// }

// class Point {
// int x;
// int y;

// Point(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }

// class Solution {
// public int[] solution() {

// String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
// { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX",
// "OXXXP", "POOXX" },
// { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP",
// "XPXPX", "PXPXP" } };

// int[] answer = new int[places.length];
// for (int i = 0; i < 5; i++) {
// answer[i] = fun(places[i]);
// }

// return answer;
// }

// private int fun(String[] str) {

// char[][] arr = new char[5][5];

// List<Point> list = new ArrayList<>();

// for (int i = 0; i < 5; i++) {
// for (int j = 0; j < 5; j++) {
// arr[i][j] = str[i].charAt(j);

// if (arr[i][j] == 'P') {
// list.add(new Point(j, i));
// }
// }
// }

// boolean[] isSafe = new boolean[list.size()];

// for (int i = 0; i < list.size(); i++) {
// isSafe[i] = BFS(arr, list.get(i));
// }

// return check(isSafe);
// }

// private int check(boolean[] isSafe) {
// for (int i = 0; i < isSafe.length; i++) {
// if (!isSafe[i]) {
// return 0;
// }
// }

// return 1;
// }

// private boolean BFS(char[][] arr, Point p) {

// int[][] visit = new int[5][5];
// for (int i = 0; i < visit.length; i++) {
// Arrays.fill(visit[i], Integer.MAX_VALUE);
// }

// int[] dx = { 0, 1, 0, -1 };
// int[] dy = { -1, 0, 1, 0 };

// int cnt = 0;
// Queue<Point> queue = new LinkedList<>();
// queue.add(p);
// visit[p.y][p.x] = cnt;

// int qSzie = queue.size();
// while (cnt != 2) {
// for (int q = 0; q < qSzie; q++) {
// Point pos = queue.poll();

// for (int dic = 0; dic < 4; dic++) {
// int nx = pos.x + dx[dic];
// int ny = pos.y + dy[dic];

// if (nx < 0 || ny < 0 || ny >= 5 || nx >= 5) {
// continue;
// }

// if (arr[ny][nx] == 'X') {
// continue;
// }

// if (visit[ny][nx] == Integer.MAX_VALUE && arr[ny][nx] == 'P') {
// return false;
// }
// if (visit[ny][nx] == Integer.MAX_VALUE) {
// queue.add(new Point(nx, ny));
// visit[ny][nx] = Math.min(cnt + 1, visit[pos.y][pos.x] + 1);
// }
// }
// }
// qSzie = queue.size();
// cnt++;
// }

// return true;
// }
// }