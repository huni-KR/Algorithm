package Lv3;

import java.util.*;

public class JewelShopping {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        s.solution(gems);
    }

    static class Data {
        int s;
        int e;
        int d;

        Data(int s, int e) {
            this.s = s + 1;
            this.e = e;
            this.d = e - s;
        }

        int getS() {
            return this.s;
        }

        int getE() {
            return this.e;
        }

        int getD() {
            return this.d;
        }
    }

    static class Solution {
        public int[] solution(String[] gems) {

            Map<String, Integer> tmap = new HashMap<>();
            for (int i = 0; i < gems.length; i++) {
                if (tmap.containsKey(gems[i])) {
                    tmap.put(gems[i], tmap.get(gems[i]) + 1);
                } else {
                    tmap.put(gems[i], 1);
                }
            }

            int[] answer = fun(gems, tmap.size());
            System.out.println(answer[0] + " " + answer[1]);
            return answer;
        }

        private int[] fun(String[] gems, int size) {
            Map<String, Integer> map = new HashMap<>();
            List<Data> list = new ArrayList<>();

            int s = 0, e = 0;
            while (s != gems.length) {

                if (isFull(map, size)) {
                    delete(map, gems[s]);
                    list.add(new Data(s++, e));
                    continue;
                }

                if (e == gems.length) {
                    s++;
                    continue;
                }

                insert(map, gems[e++]);
            }

            list.sort(Comparator.comparing(Data::getD).thenComparing(Data::getS));

            int[] result = new int[2];
            result[0] = list.get(0).s;
            result[1] = list.get(0).e;
            return result;
        }

        private void delete(Map<String, Integer> map, String str) {
            if (map.get(str) > 1) {
                map.put(str, map.get(str) - 1);
            } else {
                map.remove(str);
            }
        }

        private boolean isFull(Map<String, Integer> map, int size) {
            return map.size() == size;
        }

        private void insert(Map<String, Integer> map, String str) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
    }
}
