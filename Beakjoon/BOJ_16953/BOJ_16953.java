package BOJ_16953;

import java.io.*;
import java.util.*;

public class BOJ_16953 {

    static class Node {
        long value;
        Node left; // +1
        Node right; // *2

        Node(long v) {
            this.value = v;
            this.left = null;
            this.right = null;
        }
    }

    static class Data {
        Node node;
        long value;

        Data(Node node, long value) {
            this.node = node;
            this.value = value;
        }
    }

    static boolean flag;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Node root = new Node(A);
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(root, A));
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            if (data.value * 10 + 1 <= B) {
                data.node.left = new Node(data.value * 10 + 1);
                if (data.value * 10 + 1 == B) {
                    break;
                }
                queue.add(new Data(data.node.left, data.value * 10 + 1));
            }
            if (data.value * 2 <= B) {
                data.node.right = new Node(data.value * 2);
                if (data.value * 2 == B) {
                    break;
                }
                queue.add(new Data(data.node.right, data.value * 2));
            }
        }
        DFS(root, B, count);
        System.out.println(flag ? count : -1);
    }

    private static void DFS(Node node, long B, int cnt) {
        if (node.value == B) {
            flag = true;
            count = cnt + 1;
            return;
        }

        if (node.left != null) {
            DFS(node.left, B, cnt + 1);
        }

        if (node.right != null) {
            DFS(node.right, B, cnt + 1);
        }
    }
}