import java.util.*;

public class P01 {
    public static void main(String[] args) {

        String[] infos = { "kim password", "lee abc" };
        String[] actions = { "ADD 30", "LOGIN kim abc", "LOGIN lee password", "LOGIN kim password",
                "LOGIN kim password", "LOGIN lee abc", "ADD 30", "ORDER", "ORDER", "ADD 40", "ADD 50" };

        Solution s = new Solution();
        System.out.println(s.solution(infos, actions));

    }

    static class Solution {
        public boolean[] solution(String[] infos, String[] actions) {

            Map<String, String> info = new HashMap<>();
            for (int i = 0; i < infos.length; i++) {
                StringTokenizer st = new StringTokenizer(infos[i], " ");

                String id = st.nextToken();
                String pw = st.nextToken();
                info.put(id, pw);
            }

            boolean[] answer = new boolean[actions.length];
            Queue<String> order = new LinkedList<>();

            int pos = 0;
            boolean isLogin = false;
            for (int i = 0; i < actions.length; i++) {
                StringTokenizer st = new StringTokenizer(actions[i], " ");
                String command = st.nextToken();

                if (command.equals("LOGIN")) {

                    if (isLogin) {
                        answer[pos++] = false;
                        continue;
                    }

                    String tmpID = st.nextToken();
                    String tmpPW = st.nextToken();

                    String tmp = info.get(tmpID);

                    if (tmp == null || !info.get(tmpID).equals(tmpPW) ) {
                        answer[pos++] = false;
                    } else {
                        answer[pos++] = true;
                        isLogin = true;
                    }

                } else if (command.equals("ADD")) {

                    if (!isLogin) {
                        answer[pos++] = false;
                        continue;
                    }

                    order.add(st.nextToken());
                    answer[pos++] = true;

                } else if (command.equals("ORDER")) {

                    if (order.isEmpty()) {
                        answer[pos++] = false;
                        continue;
                    }

                    answer[pos++] = true;
                    while (!order.isEmpty()) {
                        order.poll();
                    }
                }
            }

            for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i] + " ");
            }

            return answer;
        }
    }
}
