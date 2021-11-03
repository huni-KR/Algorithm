package Lv3;

import java.util.*;

public class ExpresstionN {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        Solution s = new Solution();
        System.out.println(s.solution(N, number));
    }

    static class Solution {
        public int solution(int N, int number) {
            int answer = -1;
            List<Set<Long>> arr = new ArrayList<>();

            arr.add(null);
            arr.add(new HashSet<>());

            arr.get(1).add(new Long(N));

            for (int i = 1; i <= 8; i++) {
                if (i >= 2) {
                    arr.add(new HashSet<>());

                    StringBuilder num = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        num.append(N);
                    }
                    arr.get(i).add(Long.parseLong(num.toString()));

                    for (int j = 1; j < i; j++) {
                        for (long k : arr.get(j)) {
                            for (long l : arr.get(i - j)) {
                                arr.get(i).add(k + l);
                                arr.get(i).add(k - l);
                                arr.get(i).add(k * l);
                                if (l != 0) {
                                    arr.get(i).add(k / l);
                                }
                            }
                        }
                    }
                }

                if (arr.get(i).contains((long) number)) {
                    return i;
                }
            }
            return answer;
        }
    }
}
