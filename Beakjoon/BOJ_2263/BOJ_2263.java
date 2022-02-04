package BOJ_2263;

import java.io.*;
import java.util.*;

public class BOJ_2263 {

    static class Node {
        int value;
        Node l;
        Node r;

        Node(int value) {
            this.value = value;
            this.l = null;
            this.r = null;
        }
    }

    // preOrder : root left rigth
    // inOrder : left root right
    // postOrder : left right root
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            inOrder.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            postOrder.add(Integer.parseInt(st.nextToken()));
        }

        int root = postOrder.get(postOrder.size() - 1);
        Node node = new Node(root); 
    }
}