package Lv1;

class AddMissingNumber {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };

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