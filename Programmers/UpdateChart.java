import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class UpdateChart {

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };

        Solution s = new Solution();
        System.out.println(s.solution(n, k, cmd));
    }

    public static class Solution {
        public String solution(int n, int k, String[] cmd) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hashMap.put(i, i);
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < cmd.length; i++) {
                StringTokenizer st = new StringTokenizer(cmd[i], " ");
                String command = st.nextToken();
                if (command.equals("D")) {
                    int num = Integer.parseInt(st.nextToken());
                    k += num;
                    k %= n;
                } else if (command.equals("U")) {
                    int num = Integer.parseInt(st.nextToken());
                    k -= num;
                    k %= n;
                } else if (command.equals("C")) {
                    stack.add(hashMap.get(k));
                    hashMap.remove(k++);
                } else {
                    int value = stack.pop();
                    hashMap.put(value, value);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (hashMap.containsKey(i)) {
                    sb.append("O");
                } else {
                    sb.append("X");
                }
            }
            return sb.toString();
        }
    }
}
