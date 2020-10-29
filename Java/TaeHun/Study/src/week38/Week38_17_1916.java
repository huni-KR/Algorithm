package week38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Data implements Comparable<Data>{
	int end;
	int weight;
	public Data(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Data o) {
		return this.weight - o.weight;
	}
}

public class Week38_17_1916 {

	static ArrayList<Data>[] list;
	static int[] distance;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nV = Integer.parseInt( br.readLine() );
		int nE = Integer.parseInt( br.readLine() );
		list = new ArrayList[nV+1];
		for(int i=0; i<list.length; i++)
			list[i] = new ArrayList<Data>();
		
		distance = new int[nV+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		visit = new boolean[nV+1];		

		String[] token;
		for(int i=0; i<nE; i++) {
			token = br.readLine().split(" ");
			int a = Integer.parseInt( token[0] );
			int b = Integer.parseInt( token[1] );
			int value = Integer.parseInt( token[2] );
			
			list[a].add(new Data(b, value) );
		}
		
		token = br.readLine().split(" ");
		int start = Integer.parseInt( token[0] );
		int end = Integer.parseInt( token[1] );
		
		System.out.println( dijkstra( start, end ) );
		}

	private static int dijkstra(int start, int end) {

		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		pq.offer( new Data( start, 0 ) );
		distance[start] = 0;
		
		while( !pq.isEmpty() ) {
			Data data = pq.poll();
			int pos = data.end;
			
			if( !visit[pos] ) { 
				visit[pos] = true;
			
				for(Data d : list[pos] ) {
					if( !visit[d.end] && distance[ d.end ] > distance[pos] + d.weight ) {
						distance[d.end] = distance[pos] + d.weight;
						pq.add( new Data( d.end, distance[d.end]) );
					}
				}				
			}			
		}		
		return distance[end];
	}
}














