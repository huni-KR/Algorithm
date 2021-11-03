package Lv1;

public class MockExam {

    public static void main(String[] args) {
        int[] answers = { 1, 2, 3, 4, 5 };

        Solution s = new Solution();
        s.solution(answers);
    }

    static class Solution {
        public int[] solution(int[] answers) {
            int[] a1 = { 1, 2, 3, 4, 5 };
            int[] a2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
            int[] a3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
            int[] p = new int[3];

            for (int i = 0; i < answers.length; i++) {
                if (a1[i % a1.length] == answers[i])
                    p[0]++;
                if (a2[i % a2.length] == answers[i])
                    p[1]++;
                if (a3[i % a3.length] == answers[i])
                    p[2]++;
            }

            int max = Math.max(Math.max(p[0], p[1]), Math.max(p[1], p[2]));
            int count = 0;
            for (int i = 0; i < 3; i++)
                if (max == p[i])
                    count++;

            int[] answer = new int[count];
            int pos = 0;
            for (int i = 0; i < 3; i++)
                if (max == p[i])
                    answer[pos++] = i + 1;
            return answer;
        }
    }
}
