package BOJ_1662;

import java.io.*;
import java.util.*;

public class BOJ_1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(fun(str));
    }

    private static long fun(String str) {
        long count = 0;
        Stack<Long> len = new Stack<>();
        Stack<Integer> mul = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count--;
                int times = str.charAt(i - 1) - '0';
                len.push(count);
                mul.push(times);
                count = 0;
            } else if (c == ')') {
                int value = mul.peek();
                mul.pop();
                value *= count;
                Long plus = len.peek();
                len.pop();
                count = value + plus;
            } else {
                count++;
            }
        }
        return count;
    }
}