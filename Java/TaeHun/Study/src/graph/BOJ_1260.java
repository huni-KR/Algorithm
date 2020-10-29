package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static String dfs = "";
	
	public static void main( String[] args ) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] token = br.readLine().split(" ");
		
		int nV = Integer.parseInt( token[0] );
		int nE = Integer.parseInt( token[1] );
		int start = Integer.parseInt( token[2] );
		
		list = new ArrayList[nV+1];
		visit = new boolean[nV+1];
		for(int i=0; i<list.length; i++) 
			list[i] = new ArrayList<>();
				
		for(int i=0; i<nE; i++) {
			token = br.readLine().split(" ");
			int a = Integer.parseInt( token[0] );
			int b = Integer.parseInt( token[1] );
			
			list[a].add(b);
			list[b].add(a);		
		}

		for(int i=1; i<=nV; i++)
			Collections.sort(list[i]);
		
		DFS( start );
		System.out.println( dfs );
		resetVisit(nV);
		BFS( start );		
	}

	public static void resetVisit(int nV) {
		for(int i=1; i<=nV; i++)
			visit[i] = false;
	}

	public static void DFS(int start) {
		visit[start] = true;
		dfs += Integer.toString( start ) + " ";
		for(int i=0; i<list[start].size(); i++) 
			if( !visit[list[start].get(i)] ) 
				DFS(list[start].get(i));
	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add( start );
		visit[start] = true;
		
		String result = "";
		while( !q.isEmpty() ) {			
			int tmp = q.poll();	
			result += Integer.toString( tmp ) + " " ;	
			for(int i=0; i<list[tmp].size(); i++) 
				if( !visit[list[tmp].get(i)] ) {
					q.add( list[tmp].get(i) );
					visit[list[tmp].get(i)] = true;
				}
		}
		System.out.println( result );	
	}	
}