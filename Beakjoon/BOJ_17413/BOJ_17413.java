package BOJ_17413;

import java.io.*;
import java.util.*;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                while (!stack1.isEmpty()) {
                    bw.write(stack1.pop());
                }
                flag = true;
                stack1.push(arr[i]);
            } else if (arr[i] == '>') {
                stack1.push(arr[i]);
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                while (!stack2.isEmpty()) {
                    bw.write(stack2.pop());
                }
                flag = false;
            } else if (arr[i] == ' ' && !flag) {
                while (!stack1.isEmpty()) {
                    bw.write(stack1.pop());
                }
                bw.write(arr[i]);
            } else {
                stack1.push(arr[i]);
            }
        }
        while (!stack1.isEmpty()) {
            bw.write(stack1.pop());
        }
        bw.flush();
        bw.close();
    }
}