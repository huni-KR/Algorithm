

import java.util.*;

public class evaluation {
    public static void main(String[] args) {
        int[][] scores = { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
                { 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
        Solution s = new Solution();
        System.out.println(s.solution(scores));
    }

    static class Solution {
        public String solution(int[][] scores) {
            for (int i = 0; i < scores.length; i++) {
                if (check(scores, i)) {
                    scores[i][i] = -1;
                }
            }
            return stringMaker(scores);
        }

        private String stringMaker(int[][] scores) {
            String result = "";
            for (int i = 0; i < scores.length; i++) {
                int sum = 0, size = scores.length;
                for (int j = 0; j < scores.length; j++) {
                    if (scores[j][i] == -1) {
                        size--;
                    } else {
                        sum += scores[j][i];
                    }
                }
                sum /= size;
                if (sum >= 90) {
                    result += "A";
                } else if (sum >= 80 && sum < 90) {
                    result += "B";
                } else if (sum >= 70 && sum < 80) {
                    result += "C";
                } else if (sum >= 50 && sum < 70) {
                    result += "D";
                } else {
                    result += "F";
                }
            }
            return result;
        }

        private boolean check(int[][] scores, int i) {
            return isMin(scores, i) || isMax(scores, i);
        }

        private boolean isMax(int[][] scores, int k) {
            int count = 0;
            for (int i = 0; i < scores.length; i++) {
                if (scores[k][k] >= scores[i][k]) {
                    count++;
                }
            }
            return count == 1 ? true : false;
        }

        private boolean isMin(int[][] scores, int k) {
            int count = 0;
            for (int i = 0; i < scores.length; i++) {
                if (scores[k][k] <= scores[i][k]) {
                    count++;
                }
            }
            return count == 1 ? true : false;
        }
    }
}
