package BOJ_6068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Data implements Comparable<Data>{
    int h;
    int d;

    public Data(int h, int d){
        this.h = h;
        this.d = d;
    }

    @Override
    public int compareTo(Data o) {        
        return o.d - this.d;
    }
}

public class BOJ_6068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );

        Data[] data = new Data[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer( br.readLine(), "  ");
            int h = Integer.parseInt( st.nextToken());
            int d = Integer.parseInt( st.nextToken());
            data[i] = new Data(h, d);    
        }
        
        Arrays.sort( data );
        
        int hour = 1000000;
        for(int i=0; i<data.length; i++){
            if( hour < data[i].d )
                hour -= data[i].h;
            else
                hour = data[i].d - data[i].h;            
        }

        if( hour >= 0 )
            System.out.println( hour );
        else 
            System.out.println( -1 );
    }
}
