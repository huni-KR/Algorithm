import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2659 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine() );
		br.close();
		int a = Integer.parseInt( st.nextToken() );
		int b = Integer.parseInt( st.nextToken() );
		int c = Integer.parseInt( st.nextToken() );
		int d = Integer.parseInt( st.nextToken() );

		int min = makeMin(a,b,c,d);
		int count = 0;
		for(int i=1111; i<=min; i++) 
			if( isClockNumber(i) ) 
				count++;

		System.out.println( count );	
	}

	private static int makeMin(int a, int b, int c, int d) {
		int min = 9999;
		min = Math.min( min, fun(a,b,c,d) );
		min = Math.min( min, fun(b,c,d,a) );
		min = Math.min( min, fun(c,d,a,b) );
		min = Math.min( min, fun(d,a,b,c) );
		return min;
	}

	private static boolean isClockNumber(int i) {

		int tmp = i;
		int a = i/1000;
		i = i % 1000;
		int b = i/100;
		i = i % 100;
		int c = i/10;
		i = i % 10;
		int d = i;

		int min = makeMin(a,b,c,d);

		if( tmp == min )
			return true;		
		return false;
	}

	private static int fun(int a, int b, int c, int d) {
		return 1000*a + 100*b + 10*c + d;
	}
}