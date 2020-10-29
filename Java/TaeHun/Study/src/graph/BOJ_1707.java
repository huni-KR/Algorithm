package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//	정점 Node Vertex
//	간선 Edge

public class BOJ_1707 {

	static ArrayList<Integer>[] list;
	static int[] vertexFlag;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		for(int i=0; i<n; i++) {
			String[] token = br.readLine().split(" ");
			int nV = Integer.parseInt( token[0] );
			int nE = Integer.parseInt( token[1] );
			vertexFlag = new int[nV];
			
			list = new ArrayList[nV];
			for(int j = 0; j < list.length; j++) 
				list[j] = new ArrayList<>();			

			for(int j=0; j<nE; j++) {
				token = br.readLine().split(" ");
				int a = Integer.parseInt( token[0] ) - 1;
				int b = Integer.parseInt( token[1] ) - 1;
				list[a].add(b);
				list[b].add(a);
			}

			for(int j=0; j<nV; j++) 
				if( vertexFlag[j] == 0)
					DFS( j, 1);
			
			boolean result = check(nV);
			System.out.println( result ? "YES" : "NO" );
		}
	}

	public static boolean check(int nV) {
		for(int i=0; i<nV; i++)
			for(int j=0; j<list[i].size(); j++) {
				int next = list[i].get(j);
				if( vertexFlag[i] == vertexFlag[next] )
					return false;
			}
		return true;
	}

	public static void DFS(int vertex, int flag) {
		vertexFlag[vertex] = flag;		
		for(int i=0; i<list[vertex].size(); i++) {
			int next = list[vertex].get(i);
			if( vertexFlag[next] == 0)
				DFS( next,-flag);			
		}		
	}
}