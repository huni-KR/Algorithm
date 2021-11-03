package Lv2;

import java.util.*;

public class VowelDictionary {

    public static void main(String[] args) {
        String[] words = { "AAAAE", "AAAE", "I", "EIO", "UUUUU" };
        Solution s = new Solution();

        for (int i = 0; i < words.length; i++) {
            System.out.println(s.solution(words[i]));
        }
    }

    static class Solution {
        public int solution(String word) {
            String[] words = wordsMaker();

            return findIndex(word, words);
        }

        private int findIndex(String word, String[] words) {
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word)) {
                    return i + 1;
                }
            }
            return -1;
        }

        private String[] wordsMaker() {
            String[] vowels = { "A", "E", "I", "O", "U" };
            List[] list = new ArrayList[5];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<String>();
            }

            for (int i = 0; i < vowels.length; i++) {
                list[0].add(vowels[i]);
            }

            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    String str = (String) list[i].get(j);
                    for (int k = 0; k < vowels.length; k++) {
                        list[i + 1].add(str + vowels[k]);
                    }
                }
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    result.add((String) list[i].get(j));
                }
            }

            return result.toArray(new String[result.size()]);
        }
    }
}