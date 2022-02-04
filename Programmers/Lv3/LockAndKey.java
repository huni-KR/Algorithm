package Lv3;

public class LockAndKey {
    public static void main(String[] args) {

        int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
        int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

        Solution s = new Solution();
        System.out.println(s.solution(key, lock));
    }

    // key
    // 0 0 0
    // 1 0 0
    // 0 1 1

    // lock
    // 1 1 1
    // 1 1 0
    // 1 0 1

    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = true;
            return answer;
        }
    }
}