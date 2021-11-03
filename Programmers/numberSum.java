public class numberSum {

    public static void main(String[] args) {

        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
        // int[] numbers = { 5, 8, 4, 0, 6, 7, 9 };

        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }

    static class Solution {
        public int solution(int[] numbers) {
            boolean[] check = new boolean[10];
            for (int i = 0; i < numbers.length; i++) {
                check[numbers[i]] = true;
            }

            int answer = 0;
            for (int i = 0; i < check.length; i++) {
                if (!check[i]) {
                    answer += i;
                }
            }
            return answer;
        }
    }
}
