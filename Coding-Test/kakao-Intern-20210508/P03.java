// import java.util.*;

// public class P03 {

// public static void main(String[] args) {
// Solution s = new Solution();

// int n = 8;
// int k = 2;
// // String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
// String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1",
// "C" };
// // String[] cmd = { "C", "C", "C", "Z", "Z", "Z", "C" };

// System.out.println(s.solution(n, k, cmd));
// }
// }

// class Solution {
// public String solution(int n, int k, String[] cmd) {
// Set<Integer> originSet = new HashSet<>();
// for (int i = 0; i < n; i++) {
// originSet.add(i);
// }

// Set<Integer> newSet = command(n, k, cmd);

// return check(originSet, newSet);
// }

// private String check(Set<Integer> originSet, Set<Integer> newSet) {
// StringBuilder sb = new StringBuilder();

// for (int i : originSet) {
// if (newSet.contains(i)) {
// sb.append("O");
// } else {
// sb.append("X");
// }
// }
// return sb.toString();
// }

// private Set<Integer> command(int n, int pos, String[] cmd) {

// List<Integer> list = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// list.add(i);
// }
// Stack<Integer> stack = new Stack<>();

// for (int i = 0; i < cmd.length; i++) {
// if (cmd[i].length() == 3) {
// StringTokenizer st = new StringTokenizer(cmd[i], " ");

// char command = st.nextToken().charAt(0);
// int number = Integer.parseInt(st.nextToken());

// if (command == 'U') {
// pos -= number;
// } else if (command == 'D') {
// pos += number;
// }
// } else {
// char command = cmd[i].charAt(0);

// if (command == 'C') {
// stack.push(list.get(pos));

// if (pos == list.size() - 1) {
// list.remove(pos);
// pos--;
// } else {
// list.remove(pos);
// }

// } else if (command == 'Z') {
// int top = stack.pop();
// int index = Collections.binarySearch(list, top);

// if (index < 0) {
// index = Math.abs(index + 1);
// }

// if (index <= pos) {
// pos++;
// }

// list.add(index, top);
// }
// }
// }

// return new HashSet<>(list);
// }
// }