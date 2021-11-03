package Lv3;

import java.util.*;

public class DoublePriorityQueue {
    public static void main(String[] args) {

        String[] operations = { "I 7", "I 5", "I -5", "D -1" };
        Solution s = new Solution();
        s.solution(operations);
    }

    public static class Solution {
        public int[] solution(String[] operations) {

            PriorityQueue<Integer> orderQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < operations.length; i++) {
                StringTokenizer st = new StringTokenizer(operations[i], " ");
                String operator = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (operator.equals("I")) {
                    orderQueue.add(num);
                } else {
                    if (orderQueue.size() == 0) {
                        continue;
                    }

                    if (num == 1) {
                        orderQueue.poll();
                    } else {
                        PriorityQueue<Integer> reverseOrderQueue = new PriorityQueue<>();
                        reverseOrderQueue.addAll(orderQueue);
                        reverseOrderQueue.poll();
                        orderQueue.clear();
                        orderQueue.addAll(reverseOrderQueue);
                    }
                }
            }

            if (orderQueue.size() == 0) {
                return new int[] { 0, 0 };
            }

            int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;
            while (orderQueue.size() > 0) {
                int q = orderQueue.poll();
                maxNum = Math.max(maxNum, q);
                minNum = Math.min(minNum, q);
            }

            return new int[] { maxNum, minNum };
        }
    }
}
