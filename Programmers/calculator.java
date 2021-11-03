

public class calculator {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        Solution s = new Solution();
        System.out.println(s.solution(price, money, count));
    }

    static class Solution {
        public long solution(int price, long money, int count) {
            long result = fun(price, money, count);
            return result > 0 ? result : 0;
        }

        private long fun(int price, long money, int count) {
            long sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += price * i;
            }
            return sum - money;
        }
    }
}
