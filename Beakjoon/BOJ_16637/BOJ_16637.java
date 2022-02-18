package BOJ_16637;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_16637 {
    static BufferedReader br;
    static BufferedWriter bw;
    static List<StringBuilder> list;
    static int N, max;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        list = new ArrayList<>();

        list.add(new StringBuilder(str));
        fun(new StringBuilder(str), 0);

        max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, calc(list.get(i)));
        }

        System.out.println(max);
    }

    private static int calc(StringBuilder stringBuilder) {
        List<String> subList = removeCase(stringBuilder.toString());
        Queue<Integer> iQueue = new LinkedList<>();
        Queue<Character> operQueue = new LinkedList<>();

        for (String str : subList) {
            if (str.equals("*") || str.equals("+") || str.equals("-")) {
                operQueue.add(str.charAt(0));
            } else {
                iQueue.add(Integer.parseInt(str));
            }
        }

        int now = iQueue.poll();
        while (!operQueue.isEmpty()) {
            int a = iQueue.poll();
            char oper = operQueue.poll();
            now = value(now, a, oper);
        }

        return now;
    }

    private static List<String> removeCase(String str) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                int a = str.charAt(i + 1) - '0';
                char oper = str.charAt(i + 2);
                int b = str.charAt(i + 3) - '0';
                int sum = value(a, b, oper);
                i += 4;
                subList.add(Integer.toString(sum));
            } else {
                subList.add(Character.toString(c));
            }
        }
        return subList;
    }

    private static int value(int a, int b, char oper) {
        if (oper == '+') {
            return a + b;
        } else if (oper == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

    private static void fun(StringBuilder sb, int pos) {
        for (int i = pos; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                if (sb.length() >= i + 3) {
                    StringBuilder tmp = new StringBuilder(sb.toString());
                    tmp.insert(i, "(");
                    tmp.insert(i + 4, ")");
                    list.add(tmp);
                    i += 5;
                    fun(tmp, i);
                    i -= 5;
                } else {
                    break;
                }
            }
        }
    }
}
