package SW1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW1233 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Node[] nodes;
    static boolean flag;

    static class Node {
        String str;
        int left;
        int right;

        Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }

        Node(String str, int left) {
            this.str = str;
            this.left = left;
        }

        Node(String str) {
            this.str = str;
            this.left = -1;
            this.right = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            nodes = new Node[n + 2];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                if (st.countTokens() == 4) {
                    int idx = Integer.parseInt(st.nextToken());
                    String str = st.nextToken();
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    nodes[idx] = new Node(str, l, r);
                } else if (st.countTokens() == 3) {
                    int idx = Integer.parseInt(st.nextToken());
                    String str = st.nextToken();
                    int l = Integer.parseInt(st.nextToken());
                    nodes[idx] = new Node(str, l);
                } else {
                    int idx = Integer.parseInt(st.nextToken());
                    String str = st.nextToken();
                    nodes[idx] = new Node(str);
                }
            }

            flag = false;
            Object result = postOrder(1);
            bw.write("#" + Integer.toString(t) + " " + (flag ? "0" : "1") + "\n");
        }
        bw.flush();
    }

    private static Object postOrder(int pos) {
        if (flag) {
            return -1;
        }

        if (nodes[pos].left == -1 && nodes[pos].right == -1) {
            if (integerCheck(nodes[pos].str)) {
                return 1;
            }
            return -1;
        }

        Object left = postOrder(nodes[pos].left);
        Object right = postOrder(nodes[pos].right);

        if ((int) left == 1 && (int) right == 1 && isOperator(nodes[pos])) {
            return 1;
        }

        flag = true;
        return -1;
    }

    private static boolean integerCheck(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOperator(Node node) {
        return node.str.equals("+") || node.str.equals("-") || node.str.equals("*") || node.str.equals("/");
    }
}