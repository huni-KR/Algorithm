package BOJ_1679;

import java.io.*;
import java.util.*;

public class BOJ_1679 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(br.readLine());
        br.close();

        boolean[] table = new boolean[50001];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        for (int i = 0; i < limit; i++) {

            int size = q.size();
            for (int j = 0; j < size; j++) {
                int pos = q.poll();
                for (int k = 0; k < arr.length; k++) {
                    
                    if( table[pos + arr[k]] )
                        continue;

                    table[pos + arr[k]] = true;                    
                    q.add(pos + arr[k]);
                }
            }
        }

        int target = 1;
        for (target = 1; target < table.length; target++) {
            if (!table[target])
                break;
        }

        if (target % 2 == 0) {
            System.out.println("holsoon win at " + target);
        } else {
            System.out.println("jjaksoon win at " + target);
        }

    }
}
