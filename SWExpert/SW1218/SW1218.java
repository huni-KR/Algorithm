package SW1218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SW1218 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            bw.write("#" + Integer.toString(t) + " " + (check(str) ? "1" : "0") + "\n");
        }
        bw.flush();
    }

    private static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isClose(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return true;
    }

    private static boolean isPair(Character peek, char c) {
        if (peek == '(' && c == ')') {
            return true;
        } else if (peek == '{' && c == '}') {
            return true;
        } else if (peek == '[' && c == ']') {
            return true;
        } else if (peek == '<' && c == '>') {
            return true;
        }
        return false;
    }

    private static boolean isClose(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>';
    }
}