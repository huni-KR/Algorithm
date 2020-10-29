package week40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week40_01_2547 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int tc = Integer.parseInt( br.readLine() );
		for(int t=0; t<tc; t++) {
			br.readLine();
			int c = Integer.parseInt( br.readLine() );
			long sum = 0;
			for(int i=0; i<c; i++) 
				sum += Long.parseLong( br.readLine() ) % c;
				
			if( sum % c == 0 )
				System.out.println( "YES" );
			else
				System.out.println( "NO" );			
		}		
	}
}
