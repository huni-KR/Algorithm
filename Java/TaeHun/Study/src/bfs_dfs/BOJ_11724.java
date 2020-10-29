package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11724 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] token = br.readLine().split(" ");
		int nV = Integer.parseInt( token[0] );
		int nE = Integer.parseInt( token[1] );

		list = new ArrayList[nV+1];
		visit = new boolean[nV+1];
		for(int i=0; i<list.length; i++)
			list[i] = new ArrayList<>();

		for(int i=0; i<nE; i++) {
			token = br.readLine().split(" ");
			int from = Integer.parseInt( token[0] );
			int to = Integer.parseInt( token[1] );

			list[from].add(to);
			list[to].add(from);			
		}

		while( true ) {			
			if( isAllVisit(nV) ) 
				break;			
			for(int i=1; i<nV; i++) 
				if( !visit[i] ) {
					DFS(i);
					count++;
				}
		}		

		for(int i=1; i<nV; i++) 
			if( !visit[i] )
				count++;

		System.out.println( count );
	}

	private static boolean isAllVisit(int nV) {
		for(int i=1; i<nV; i++)
			if( !visit[i] )
				return false;
		return true;
	}

	private static void DFS(int pos) {

		visit[pos] = true;

		for(int i=0; i<list[pos].size(); i++) 
			if( !visit[ list[pos].get(i) ] ) {
				visit[ list[pos].get(i) ] = true;
				DFS( list[pos].get(i) );
			}		
	}
}






