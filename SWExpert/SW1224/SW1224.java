package SW1224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW1224 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            toPostfix(br.readLine());
            bw.write("#" + Integer.toString(t) + " " + Integer.toString(fun(sb.toString())) + "\n");
        }
        bw.flush();
    }

    private static void toPostfix(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }

            if (c == '(' || stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (c == '*') {
                stack.push(c);
            } else if (c == '+') {
                while (stack.peek() == '*') {
                    sb.append(stack.pop());
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(c);
            }
        }
    }

    private static int fun(String str) {
        Stack<Integer> iStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                iStack.push(c - '0');
            } else {
                int b = iStack.pop();
                int a = iStack.pop();
                iStack.push(calc(a, b, c));
            }
        }
        return iStack.pop();
    }

    private static Integer calc(int a, int b, Character pop) {
        return pop == '+' ? a + b : a * b;
    }
}