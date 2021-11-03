package Lv3;

import java.util.*;

public class FarthestNode {

    public static void main(String[] args) {

        int n = 6;
        int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        Solution s = new Solution();
        System.out.println(s.solution(n, vertex));
    }

    static class Solution {
        public int solution(int n, int[][] edge) {

            ArrayList<Integer>[] list = new ArrayList[n + 1];
            for (int i = 1; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge.length; i++) {
                int a = edge[i][0];
                int b = edge[i][1];

                list[a].add(b);
                list[b].add(a);
            }

            int[] weight = new int[n + 1];
            Arrays.fill(weight, Integer.MAX_VALUE);

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            weight[1] = 0;

            int count = 0;
            while (!q.isEmpty()) {
                count++;

                int qSize = q.size();
                for (int s = 0; s < qSize; s++) {

                    int tmp = q.poll();

                    for (int i : list[tmp]) {

                        if (weight[i] == Integer.MAX_VALUE)
                            q.add(i);
                        weight[i] = Math.min(weight[i], count);
                    }
                }
            }

            int max = 0;
            for (int i = 1; i < weight.length; i++) {
                max = Math.max(max, weight[i]);
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 1; i < weight.length; i++)
                if (max == weight[i])
                    result.add(i);

            return result.size();
        }
    }
}
