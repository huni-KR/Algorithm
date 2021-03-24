package BOJ_1931;

import java.io.*;
import java.util.*;

class Meeting{
    int s;
    int e;

    Meeting(int s, int e){
        this.s = s;
        this.e = e;
    }
    
    public int getS() {
        return s;
    }

    public int getE() {
        return e;
    }
}

public class BOJ_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meeting =new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meeting.add(new Meeting(s, e));
        }   
        meeting.sort(Comparator.comparing(Meeting::getE).thenComparing(Meeting::getS));

        int count = 0;
        int time = 0;
        for(Meeting m : meeting){
            if( time <= m.s ){
                time = m.e;
                count++;
            }
        }

        System.out.println( count );
    }
}