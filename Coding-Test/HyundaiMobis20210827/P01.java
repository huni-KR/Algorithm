import java.util.*;

public class P01 {
    public static void main(String[] args) {

        int[][] dice = { { 1, 6, 2, 5, 3, 4 }, { 9, 9, 1, 0, 7, 8 } };

        Solution s = new Solution();
        System.out.println(s.solution(dice));

    }

    static class Solution {
        public int solution(int[][] dice) {

            for (int i = 0; i < dice.length; i++) {
                Arrays.sort(dice[i]);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < dice.length; i++) {
                for (int j = 0; j < dice[0].length; j++) {
                    set.add(dice[i][j]);
                }
            }

            for (int i = 0; i < dice[0].length; i++) {
                for (int j = 0; j < dice[0].length; j++) {
                    
                }
            }

            int answer = findMin(set);
            return answer;
        }

        private int findMin(Set<Integer> set) {

            int min = 1;
            while (set.contains(min++)) {

            }
            return min - 1;
        }
    }
}