

public class wordTtanslation {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        Solution s = new Solution();
        s.solution(begin, target, words);
    }

    static class Solution {
        public int solution(String begin, String target, String[] words) {
            return fun(begin, target, words);
        }

        private int fun(String begin, String target, String[] words) {
            if (!isContain(target, words) || isOne(begin, words)) {
                return 0;
            }

            return 0;
        }

        private boolean isOne(String begin, String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!isDiffOne(begin, words[i])) {
                    return false;
                }
            }
            return true;
        }

        private boolean isDiffOne(String begin, String str) {
            int count = 0;
            for (int i = 0; i < begin.length(); i++) {
                if (begin.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count <= 1 ? true : false;
        }

        private boolean isContain(String target, String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (target.equals(words[i])) {
                    return true;
                }
            }
            return false;
        }
    }
}
