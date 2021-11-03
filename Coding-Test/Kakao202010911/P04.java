import java.util.Arrays;

public class P04 {
    public static void main(String[] args) {

        int n = 5;
        int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };

        Solution s = new Solution();
        s.solution(n, info);
    }

    static class Solution {
        public int[] solution(int n, int[] info) {
            int[] lion = new int[info.length];

            int[] maxArray = new int[info.length];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < info.length; i++) {

                int[] result = new int[info.length];

                result[i] = 

                for (int j = i + 1; j < info.length; j++) {

                }

                int gap = gapCheck(info, lion);
                if (max < gap) {
                    max = gap;
                    maxArray = Arrays.copyOf(result, result.length);
                }
            }

            if (max == Integer.MIN_VALUE) {
                int[] answer = { -1 };
                return answer;
            } else {
                return maxArray;
            }
        }

        private int gapCheck(int[] info, int[] lion) {
            int score = 10;
            int[] sum = new int[2];
            for (int i = 0; i < info.length; i++) {
                if (info[i] < lion[i]) {
                    sum[1] += score--;
                } else {
                    sum[0] += score--;
                }
            }

            return sum[1] - sum[0];
        }
    }
}
