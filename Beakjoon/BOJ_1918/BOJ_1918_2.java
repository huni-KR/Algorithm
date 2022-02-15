package BOJ_1918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_1918_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stack = new Stack<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                bw.write(c);
                continue;
            }

            if (c == '(' || stack.isEmpty()) {
                stack.add(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    bw.write(stack.pop());
                }
                stack.pop();
            } else if (c == '+' || c == '-') {
                while (stack.peek() != '(') {
                    bw.write(stack.pop());
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(c);
            } else {
                while (stack.peek() == '*' || stack.peek() == '/') {
                    bw.write(stack.pop());
                    if (stack.isEmpty() || stack.peek() == '(') {
                        break;
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
    }
}