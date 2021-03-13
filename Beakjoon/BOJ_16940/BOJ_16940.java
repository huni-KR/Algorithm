package BOJ_16940;

import java.io.*;
import java.util.*;

public class BOJ_16940 {
    
    static Map map;
    static List[] list;
    static boolean[] visit;
    static Queue queue;
    static Queue result;
    public static void main(String[] args) throws NumberFormatException, IOException{
        
        result = new LinkedList<>();
        map = new HashMap<Integer, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // bfs(arr[0], 1);
        
        // for(int i=0; i<n; i++){
        //     arr[i] = (int)map.get(arr[i]);
        // }

        boolean flag = isBFS(arr);

        System.out.println( flag ? 1 : 0);

        // for(int i=0; i<n; i++){
        //     System.out.print(arr[i] + " ");
        // }

    }
    private static boolean isBFS(int[] arr) {
        result.add(arr[0]);
        visit[arr[0]] = true;

        



        
        return true;
    }
    // private static void bfs(int pos, int level) {
        
    //     visit[pos] = true;

    //     if( map.get(pos) == null){
    //         map.put(pos, level);
    //     }
        

    //     queue = new LinkedList<Integer>();
    //     queue.add(pos);

    //     while(!queue.isEmpty()){

    //         int now = (int) queue.poll();

    //         for(int i=0; i<list[now].size(); i++){
    //             if( !visit[(int) list[now].get(i)] ){
    //                 bfs((int) list[now].get(i), level+1);
    //             }
    //         }


    //     }
    // }    
}
