public class P06 {
    public static void main(String[] args) {

        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };

        Solution s = new Solution();
        s.solution(board, skill);
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {

            for (int i = 0; i < skill.length; i++) {
                int type = skill[i][0], degree = skill[i][5];
                int r1 = skill[i][1], c1 = skill[i][2], r2 = skill[i][3], c2 = skill[i][4];

                for (int j = r1; j <= r2; j++) {
                    for (int k = c1; k <= c2; k++) {
                        if (type == 1) {
                            board[j][k] -= degree;
                        } else {
                            board[j][k] += degree;
                        }
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] > 0) {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
