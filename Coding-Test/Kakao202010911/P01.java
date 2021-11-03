import java.util.*;

public class P01 {

    public static void main(String[] args) {

        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;

        Solution s = new Solution();
        s.solution(id_list, report, k);
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < id_list.length; i++) {
                map.put(id_list[i], i);
            }

            HashSet<String>[] set = new HashSet[id_list.length];
            for (int i = 0; i < set.length; i++) {
                set[i] = new HashSet<>();
            }

            for (int i = 0; i < report.length; i++) {
                StringTokenizer st = new StringTokenizer(report[i], " ");
                String user1 = st.nextToken();
                String user2 = st.nextToken();

                set[map.get(user1)].add(user2);
            }

            HashMap<String, Integer> resultMap = new HashMap<>();

            for (int i = 0; i < set.length; i++) {
                for (String str : set[i]) {
                    if (resultMap.containsKey(str)) {
                        resultMap.put(str, resultMap.get(str) + 1);
                    } else {
                        resultMap.put(str, 1);
                    }
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < set.length; i++) {
                for (String str : set[i]) {
                    if (resultMap.get(str) >= k) {
                        answer[i]++;
                    }
                }
            }

            return answer;
        }
    }
}
