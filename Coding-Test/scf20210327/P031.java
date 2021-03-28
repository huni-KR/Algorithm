import java.io.*;
import java.util.*;

public class P031 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        
        List<Integer>[] list = new ArrayList[nV+1];
        for(int i=1; i<nV+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<nV-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
        }

        for (int i = 0; i < nE; i++) {            
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println( BFS(list, start, end) ? "yes" : "no" );
        }        
    }

    private static boolean BFS(List<Integer>[] list, int start, int end) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        while( !queue.isEmpty() ){
            int pos = queue.poll();

            for(int i : list[pos]){
                if( i == end )
                    return true;
                queue.add(i);
            }
        }

        return false;
    }
}