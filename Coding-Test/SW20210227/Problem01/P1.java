import java.io.*;
import java.util.*;

public class P1 {

    static int start;
    static int[] arr;
    static ArrayList<Integer>[] list;
    static int[] target;
    static boolean[] visit = new boolean[52];
    static Queue<Character> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        arr = new int[st.countTokens()];
        for(int i=0; i<arr.length; i++){
            arr[i] = st.nextToken().charAt(0)-'a';
        }

        list = new ArrayList[52];
        target = new int[52];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        start = arr[0];

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = st.nextToken().charAt(0) -'a';
            int b = st.nextToken().charAt(0) -'a';

            target[a]++;
            target[b]++;

            list[a].add(b);
            list[b].add(a);
        }

        dfs(start, "");

    }

    static void dfs(int index, String str){

        visit[index] = true;
        str += (char)(index + 'a') + " ";

        for(int i=0; i<list[index].size(); i++){
            if( !visit[list[index].get(i)] ){
                dfs(list[index].get(i), str);
            }
        }
        if( target[index] == 1 )
            System.out.println( str );
    }
}

/*
h g f w r
4
h g
h f
g r
g w
*/