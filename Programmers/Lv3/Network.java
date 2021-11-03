package Lv3;

import java.util.*;

public class Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        Solution s = new Solution();
        System.out.println(s.solution(n, computers));
    }

    static class Solution {
        List<Integer>[] list;
        boolean[] visit;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        public int solution(int n, int[][] computers) {

            visit = new boolean[n];

            list = new ArrayList[n + 1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (computers[i][j] == 1) {
                        list[i].add(j);
                        list[j].add(i);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    BFS(computers, i);
                    answer++;
                }
            }

            return answer;
        }

        public void BFS(int[][] computers, int start) {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visit[start] = true;

            while (!q.isEmpty()) {
                int tmp = q.poll();
                for (int i = 0; i < list[tmp].size(); i++) {
                    if (!visit[list[tmp].get(i)]) {
                        q.add(list[tmp].get(i));
                        visit[list[tmp].get(i)] = true;
                    }
                }
            }
        }
    }
}
