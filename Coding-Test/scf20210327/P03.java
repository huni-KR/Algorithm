import java.io.*;
import java.util.*;

public class P03 {

    static int[] parent;   
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        
        List<Integer>[] list = new ArrayList[nV+1];
        for(int i=1; i<nV+1; i++){
            list[i] = new ArrayList<>();
        }
        
        parent = new int[nV+1]; 
        for (int i = 1; i < parent.length; i++) {
            parent[i]=i;
        } 

        for(int i=0; i<nV-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int a = find(start); 
            int b = find(end);   
            if( a == b ) continue;
                
            union(start, end); 
        }

        

        for (int i = 0; i < nE; i++) {            
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());



                
        }
        
    }

    public static int find(int x) {
		if(x == parent[x]) return x;
		int y = find(parent[x]);
		parent[x] = y;
		return y;
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) parent[y] = x;
	}
}