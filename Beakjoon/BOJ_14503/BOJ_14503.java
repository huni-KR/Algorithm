package BOJ_14503;

import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Robot{
    Point p;
    int d;

    Robot(Point p, int d){
        this.p = p;
        this.d = d;
    }
}

public class BOJ_14503 {
    
    static int x;
    static int y;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];

        st = new StringTokenizer(br.readLine(), " ");
        int tmpY = Integer.parseInt(st.nextToken());
        int tmpX = Integer.parseInt(st.nextToken());
        Robot r = new Robot(new Point(tmpX, tmpY), Integer.parseInt(st.nextToken()));
                
        for(int i=0; i<y; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<x; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println();

        System.out.println();




    }
}
