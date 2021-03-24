import java.io.*;
import java.util.*;

class Schedule{
    int s;
    int e;

    Schedule(int s, int e){
        this.s = s;
        this.e = e;
    }
}

public class P01 {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Schedule> list = new ArrayList<Schedule>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ~ ");
            StringTokenizer startTime = new StringTokenizer(st.nextToken(), ":");
            StringTokenizer endTime = new StringTokenizer(st.nextToken(), ":");
            
            int start = Integer.parseInt(startTime.nextToken())*100 + Integer.parseInt(startTime.nextToken());
            int end = Integer.parseInt(endTime.nextToken())*100 + Integer.parseInt(endTime.nextToken());

            list.add(new Schedule(start, end));
        }

        int end = Integer.MAX_VALUE;
        int start = 0;

        for(Schedule s : list){
            end = Math.min(end, s.e);
            start = Math.max(start, s.s);
        }

        if( start <= end ){
            String strStart = "";
            if( start/100 < 10 ){
                strStart += "0" + Integer.toString(start/100) + ":";
            }else{
                strStart += Integer.toString(start/100) + ":";
            }
            if( start%100 < 10 ){
                strStart += "0" + Integer.toString(start%100);
            }else{
                strStart += Integer.toString(start%100);
            }

            String strEnd = "";
            if( end/100 < 10 ){
                strEnd += "0" + Integer.toString(end/100) + ":";
            }else{
                strEnd += Integer.toString(end/100) + ":";
            }
            if( end%100 < 10 ){
                strEnd += "0" + Integer.toString(end%100);
            }else{
                strEnd += Integer.toString(end%100);
            }
            
            System.out.println( strStart + " ~ " + strEnd);
        }else{
            System.out.println("-1");
        }
    }
}


/*
3
12:00 ~ 23:59
11:00 ~ 18:00
14:00 ~ 20:00
*/