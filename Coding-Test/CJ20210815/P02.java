import java.util.*;

public class P02 {
    public static void main(String[] args) {
        String[] subway = { "1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21" };
        int start = 1;
        int end = 9;
        Solution s = new Solution();
        System.out.println(s.solution(subway, start, end));
    }

    class Station {
        int nubmer;
        List<Integer> lines = new ArrayList<>();

        Station(int n, int line) {
            this.nubmer = n;
            lines.add(line);
        }
    }

    static class Solution {
        public int solution(String[] subway, int start, int end) {

            List[] list = new ArrayList[subway.length];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < subway.length; i++) {
                StringTokenizer st = new StringTokenizer(subway[i], " ");

                while (st.hasMoreTokens()) {
                    list[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            System.out.println(1);

            return 0;
        }
    }
}
