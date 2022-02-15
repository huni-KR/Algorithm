package SW1223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW1223 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            bw.write("#" + Integer.toString(t) + " " + Integer.toString(fun(br.readLine())) + "\n");
        }
        bw.flush();
    }

    private static int fun(String str) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                intStack.push(c - '0');
            } else {
                if (operStack.isEmpty()) {
                    operStack.push(c);
                    continue;
                }

                if (c == '+') {
                    while (operStack.peek() == '*') {
                        int b = intStack.pop();
                        int a = intStack.pop();
                        intStack.push(calc(a, b, operStack.pop()));
                        if (operStack.isEmpty()) {
                            break;
                        }
                    }
                }
                operStack.push(c);
            }

        }
        while (!operStack.isEmpty()) {
            int b = intStack.pop();
            int a = intStack.pop();
            intStack.push(calc(a, b, operStack.pop()));
        }

        return intStack.pop();
    }

    private static int calc(int a, int b, char c) {
        return c == '+' ? a + b : a * b;
    }
}