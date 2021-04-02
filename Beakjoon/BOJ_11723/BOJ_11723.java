package BOJ_11723;

import java.io.*;
import java.util.*;

public class BOJ_11723 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<Integer>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            String command = st.nextToken();

            if( command.equals("add") ){
                set.add( Integer.parseInt(st.nextToken()) );
            }else if( command.equals("remove") ){
                set.remove( Integer.parseInt(st.nextToken()) );                
            }else if( command.equals("check") ){
                bw.write( set.contains( Integer.parseInt(st.nextToken()) ) ? "1\n" : "0\n");
            }else if( command.equals("toggle") ){
                int tmp = Integer.parseInt(st.nextToken());
                if( set.contains( tmp ) ) set.remove(tmp);
                else set.add(tmp);
            }else if( command.equals("all") ){
                for(int t=1; t<=20; t++) set.add(t);
            }else if( command.equals("empty") ){
                set = new HashSet<Integer>();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
