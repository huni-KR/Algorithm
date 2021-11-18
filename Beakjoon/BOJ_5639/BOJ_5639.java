package BOJ_5639;

import java.io.*;

public class BOJ_5639 {

    static class Node {
        int value;
        Node l;
        Node r;

        Node(int value, Node l, Node r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        Node node = null;
        while ((str = br.readLine()) != null) {
            int value = Integer.parseInt(str);
            if (node == null) {
                node = new Node(value, null, null);
            } else {
                node = fun(node, value);
            }
        }
        postOrder(node);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.l);
        postOrder(node.r);

        System.out.println(node.value);
    }

    private static Node fun(Node node, int value) {
        if (node.value < value) {
            if (node.r == null) {
                node.r = new Node(value, null, null);
            } else {
                fun(node.r, value);
            }
        } else {
            if (node.l == null) {
                node.l = new Node(value, null, null);
            } else {
                fun(node.l, value);
            }
        }
        return node;
    }
}
