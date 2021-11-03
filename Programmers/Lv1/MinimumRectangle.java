package Lv1;

public class MinimumRectangle {

    public static void main(String[] args) {
        int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

        Solution s = new Solution();
        System.out.println(s.solution(sizes));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int a = 0, b = 0;
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i][0] < sizes[i][1]) {
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
                a = Math.max(a, sizes[i][0]);
                b = Math.max(b, sizes[i][1]);
            }
            return a * b;
        }
    }
}
