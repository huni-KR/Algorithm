// public class P01 {

// public static void main(String[] args) {
// Solution s = new Solution();

// System.out.println(s.solution("2three45sixseven"));
// }
// }

// class Solution {
// public int solution(String s) {
// return fun(s);
// }

// private int fun(String s) {
// String result = "";

// int start = 0, end = 0;

// for (int i = 0; i < s.length(); i++) {
// if (Character.isDigit(s.charAt(i))) {
// start = i + 1;
// result += s.charAt(i);
// continue;
// } else {
// end = i;
// }

// String tmp = StringToInteger(s.substring(start, end + 1));
// if (tmp != null) {
// start = i + 1;
// result += tmp;
// }
// }
// return Integer.parseInt(result);
// }

// private String StringToInteger(String str) {
// if (str.equals("zero")) {
// return "0";
// } else if (str.equals("one")) {
// return "1";
// } else if (str.equals("two")) {
// return "2";
// } else if (str.equals("three")) {
// return "3";
// } else if (str.equals("four")) {
// return "4";
// } else if (str.equals("five")) {
// return "5";
// } else if (str.equals("six")) {
// return "6";
// } else if (str.equals("seven")) {
// return "7";
// } else if (str.equals("eight")) {
// return "8";
// } else if (str.equals("nine")) {
// return "9";
// }
// return null;
// }
// }