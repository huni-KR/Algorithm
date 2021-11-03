

import java.util.*;

public class puzzle {

    public static void main(String[] args) {

        int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };

        int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };

        Solution s = new Solution();
        s.solution(game_board, table);
    }

    static class Solution {

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        public int solution(int[][] game_board, int[][] table) {

            int answer = -1;
            return answer;
        }

    }

}

class Data {
    int x;
    int y;

    Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
