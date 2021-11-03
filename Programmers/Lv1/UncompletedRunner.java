package Lv1;

import java.util.*;

public class UncompletedRunner {
    public static void main(String[] args) {
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };

        Solution s = new Solution();
        System.out.println(s.solution(participant, completion));
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {

            Arrays.sort(participant);
            Arrays.sort(completion);

            for (int i = 0; i < participant.length - 1; i++) {
                if (!participant[i].equals(completion[i])) {
                    return participant[i];
                }
            }

            return participant[participant.length - 1];
        }
    }
}
