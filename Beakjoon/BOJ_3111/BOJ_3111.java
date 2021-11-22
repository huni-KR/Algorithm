package BOJ_3111;

import java.io.*;
import java.util.*;

public class BOJ_3111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String rA = new StringBuilder().append(A).reverse().toString();
        String T = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        boolean isRight = true;
        int front = 0, rear = T.length() - 1;
        while (front <= rear) {
            boolean flag = true;
            if (isRight) {
                left.push(T.charAt(front++));
                if (left.size() >= A.length() && left.peek() == A.charAt(A.length() - 1)) {
                    for (int i = left.size() - A.length(); i < left.size(); i++) {
                        if (left.get(i) != A.charAt(i - left.size() + A.length())) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int i = 0; i < A.length(); i++) {
                            left.pop();
                        }
                        isRight = !isRight;
                    }
                }
            } else {
                right.push(T.charAt(rear--));
                if (right.size() >= rA.length() && right.peek() == rA.charAt(rA.length() - 1)) {
                    for (int i = right.size() - rA.length(); i < right.size(); i++) {
                        if (right.get(i) != rA.charAt(i - right.size() + rA.length())) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int i = 0; i < rA.length(); i++) {
                            right.pop();
                        }
                        isRight = !isRight;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        int leftSize = left.size(), rightSize = right.size();
        for (int i = 0; i < leftSize; i++) {
            sb.append(left.pop());
        }
        sb.reverse();
        for (int i = 0; i < rightSize; i++) {
            sb.append(right.pop());
        }

        while (true) {
            int index = sb.indexOf(A);
            if (index < 0) {
                break;
            }
            sb.delete(index, index + A.length());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}