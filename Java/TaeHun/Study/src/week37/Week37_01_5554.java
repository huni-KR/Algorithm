package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week37_01_5554 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<4; i++)
			sum += Integer.parseInt( br.readLine() );
		br.close();
		System.out.println( sum/60 + "\n" + sum%60 );
	}
}
