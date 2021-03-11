package BOJ_11650;

import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

public class BOJ_11650 {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List list = new ArrayList<Point>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x, y));
        }

        list.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));

        int size = list.size();
        for(int i=0; i<size; i++){
            Point tmp = (Point) list.get(i);
            System.out.println( tmp.x + " " + tmp.y);
        }       
    }
}