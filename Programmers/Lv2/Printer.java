package Lv2;

import java.util.*;

public class Printer {

    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;

        Solution s = new Solution();
        System.out.println(s.solution(priorities, location));
    }

    static class Data {
        int pos;
        int priorities;

        public Data(int pos, int priorities) {
            this.pos = pos;
            this.priorities = priorities;
        }
    }

    static class Solution {
        public int solution(int[] priorities, int location) {

            Data target = new Data(location, priorities[location]);

            Queue<Data> queue = new LinkedList<Data>();
            for (int i = 0; i < priorities.length; i++)
                queue.add(new Data(i, priorities[i]));

            Arrays.sort(priorities);
            int pos = priorities.length - 1;
            int max = priorities[pos];

            Queue<Data> tmpQueue = new LinkedList<Data>();
            while (!queue.isEmpty()) {
                Data tmp = queue.poll();
                if (tmp.priorities == max) {
                    tmpQueue.add(tmp);
                    if (queue.isEmpty())
                        break;
                    max = priorities[--pos];
                } else
                    queue.add(tmp);
            }

            int answer = 0;
            while (!tmpQueue.isEmpty()) {
                answer++;
                Data tmp = tmpQueue.poll();
                if (target.pos == tmp.pos && target.priorities == target.priorities)
                    break;
            }
            return answer;
        }
    }
}
