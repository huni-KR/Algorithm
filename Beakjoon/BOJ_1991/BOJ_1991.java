package BOJ_1991;

import java.io.*;
import java.util.*;

class Node {
    char item;
    Node left;
    Node rigth;

    Node(char i) {
        this.item = i;
    }
}

public class BOJ_1991 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l != '.') {
                tree[root - 'A'].left = tree[l - 'A'];
            }

            if (r != '.') {
                tree[root - 'A'].rigth = tree[r - 'A'];
            }

        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        preOrder(bw, tree, 0);
        bw.write("\n");
        inOrder(bw, tree, 0);
        bw.write("\n");
        postOrder(bw, tree, 0);

        bw.flush();
        bw.close();
    }

    private static void preOrder(BufferedWriter bw, Node[] tree, int index) throws IOException {
        bw.write(tree[index].item);
        if (tree[index].left != null)
            preOrder(bw, tree, tree[index].left.item - 'A');
        if (tree[index].rigth != null)
            preOrder(bw, tree, tree[index].rigth.item - 'A');
    }

    private static void inOrder(BufferedWriter bw, Node[] tree, int index) throws IOException {
        if (tree[index].left != null)
            inOrder(bw, tree, tree[index].left.item - 'A');
        bw.write(tree[index].item);
        if (tree[index].rigth != null)
            inOrder(bw, tree, tree[index].rigth.item - 'A');
    }

    private static void postOrder(BufferedWriter bw, Node[] tree, int index) throws IOException {
        if (tree[index].left != null)
            postOrder(bw, tree, tree[index].left.item - 'A');
        if (tree[index].rigth != null)
            postOrder(bw, tree, tree[index].rigth.item - 'A');
        bw.write(tree[index].item);
    }

}
