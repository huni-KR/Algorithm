package BOJ_2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Line {
	int s;
	int e;
	public Line(int s, int e) {
		this.s = s;
		this.e = e;
	}
}

public class BOJ_2170 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		ArrayList<Line> list = new ArrayList<Line>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer( br.readLine(), " " );
			int s = Integer.parseInt( st.nextToken() );
			int e = Integer.parseInt( st.nextToken() );
			if( s > e ){
				int tmp = s;
				s = e;
				e = tmp;
			}
			list.add( new Line( s, e ) );			
		}
		list.sort(new Comparator<Line>() {

			@Override
			public int compare(Line l1, Line l2) {
				if( l1.s > l2.s )
					return 1;
				else if( l1.s == l2.s )
					return 0;
				else
					return -1;
			}
		});
		
		int result = 0, l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
		
		for(Line tmp : list) {
			if( r < tmp.s ) {
				result += r-l;
				l = tmp.s;
				r = tmp.e;
			}
			else
				r = Math.max(r, tmp.e);
		}
	    result += r-l; 
	    System.out.println( result );		
	}

}
