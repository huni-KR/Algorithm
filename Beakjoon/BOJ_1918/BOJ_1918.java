package BOJ_1918;

import java.io.*;
import java.util.*;

public class BOJ_1918 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    char op = stack.pop();
                    if (op == '(') {
                        break;
                    }
                    sb.append(op);
                }
            } else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int getPriority(char c) {
        if (c == '(') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}