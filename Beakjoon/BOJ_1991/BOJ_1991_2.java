package BOJ_1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1991_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static Node root;

    static class Node {
        char c;
        Node left;
        Node right;

        Node(char c) {
            this.c = c;
        }

        void add(Node node, char target, char l, char r) {
            if (node == null) {
                return;
            } else if (node.c == target) {
                if (l != '.') {
                    node.left = new Node(l);
                }
                if (r != '.') {
                    node.right = new Node(r);
                }
            } else {
                add(node.left, target, l, r);
                add(node.right, target, l, r);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        root = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char s = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Node left = null;
            Node right = null;
            if (l != '.') {
                left = new Node(l);
            }
            if (r != '.') {
                right = new Node(r);
            }

            if (root == null) {
                root = new Node(s);
                root.left = left;
                root.right = right;
            } else {
                root.add(root, s, l, r);
            }
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.c);
    }

    private static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.c);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private static void preOrder(Node node) {
        System.out.print(node.c);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }
}