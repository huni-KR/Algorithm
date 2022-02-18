package BOJ_2250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// # 1
public class BOJ_2250 {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Node root = null;

        List<Node> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            Node node = new Node(p, new Node(l, null, null), new Node(r, null, null));

            if (root == null) {
                root = node;
                continue;
            }

            if (root.value == l) {
                node.left = root;
                root = node;
            } else if (root.value == r) {
                node.right = root;
                root = node;
            } else {
                if (list.isEmpty()) {
                    list.add(node);
                }

                int leftIndex = getIndex(list, root.left.value);
                if (leftIndex != -1) {
                    Node tmp = list.get(leftIndex);
                    root.left = tmp;
                    list.remove(leftIndex);
                }

                int rightIndex = getIndex(list, root.right.value);
                if (rightIndex != -1) {
                    Node tmp = list.get(rightIndex);
                    root.right = tmp;
                    list.remove(rightIndex);
                }

            }
        }
        System.out.println(1);

    }

    private static int getIndex(List<Node> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).value == target) {
                return i;
            }
        }
        return -1;
    }

}