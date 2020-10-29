package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_13023 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");		
		int nV = Integer.parseInt( token[0] );
		int nE = Integer.parseInt( token[1] );

		list = new ArrayList[nV];
		for(int i=0; i<list.length; i++)
			list[i] = new ArrayList<>();
		
		visit = new boolean[nV];
		for(int i=0; i<nE; i++) {
			token = br.readLine().split(" ");
			int a = Integer.parseInt( token[0] );
			int b = Integer.parseInt( token[1] );
			list[a].add(b);
			list[b].add(a);			
		}

		for(int i=0; i<nV; i++) {
			DFS(i, 1);
			if( flag )
				break;		
		}
		System.out.println( flag ? 1 : 0 );		
	}

	private static void DFS(int pos, int depth) {

		if( depth == 5 || flag ) {
			flag = true;
			return;
		}
		visit[pos] = true;
		
		for(int i=0; i<list[pos].size(); i++ ) {
			if( !visit[list[pos].get(i)] ) {
				visit[list[pos].get(i)] = true;
				DFS( list[pos].get(i), depth + 1 );
				visit[list[pos].get(i)] = false;
			}			
		}
		visit[pos] = false;		
	}
}