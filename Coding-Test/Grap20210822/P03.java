import java.util.*;

public class P03 {

    public static void main(String[] args) {
        String word = "APPLE";
        String[] cards = { "LLZKE", "LCXEA", "CVPPS", "EAVSR", "FXPFP" };

        Solution s = new Solution();
        System.out.println(s.solution(word, cards));

    }

    static class Solution {
        public int solution(String word, String[] cards) {

            char[][] arr = new char[cards.length][cards[0].length()];

            for (int i = 0; i < cards.length; i++) {
                for (int j = 0; j < cards[0].length(); j++) {
                    arr[i][j] = cards[i].charAt(j);
                }
            }

            Map<Character, Integer> alpaMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                if (alpaMap.containsKey(word.charAt(i))) {
                    alpaMap.put(word.charAt(i), alpaMap.get(word.charAt(i)) + 1);
                } else {
                    alpaMap.put(word.charAt(i), 1);
                }
            }

            int answer = -1;
            return answer;
        }
    }
}