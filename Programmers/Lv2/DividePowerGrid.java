package Lv2;

import java.util.*;

public class DividePowerGrid {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };

        Solution s = new Solution();
        System.out.println(s.solution(n, wires));
    }

    static class Solution {
        public int solution(int n, int[][] wires) {

            ArrayList[] list = new ArrayList[n + 1];
            for (int i = 1; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < wires.length; i++) {
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];

                list[a].remove(list[a].indexOf(b));
                list[b].remove(list[b].indexOf(a));

                answer = Math.min(answer, BFS(list));

                list[a].add(b);
                list[b].add(a);
            }
            return answer;
        }

        private int BFS(ArrayList[] list) {

            boolean[] visit = new boolean[list.length];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            visit[1] = true;

            while (!queue.isEmpty()) {
                int pos = queue.poll();

                for (int i = 0; i < list[pos].size(); i++) {

                    int tmp = (int) list[pos].get(i);

                    if (!visit[tmp]) {
                        visit[tmp] = true;
                        queue.add(tmp);
                    }
                }
            }

            int[] visitCount = new int[2];
            for (int i = 1; i < visit.length; i++) {
                if (visit[i]) {
                    visitCount[0]++;
                } else {
                    visitCount[1]++;
                }
            }
            return Math.abs(visitCount[0] - visitCount[1]);
        }
    }
}
