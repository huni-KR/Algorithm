// import java.util.*;

// public class P02 {
    
//     public static void main(String[] args){
//         Solution s = new Solution();

//         // int rows = 6;
//         // int columns = 6;
//         // int[][] queries = {
//         //     {2,2,5,4},
//         //     {3,3,6,6},
//         //     {5,1,6,3}
//         // };

//         int rows = 100;
//         int columns = 97;
//         int[][] queries = {
//             {1,1,100,97}
//         };

//         System.out.println( s.solution( rows, columns, queries ) );
//     }
// }

// class Solution {
//     public int[] solution(int rows, int columns, int[][] queries) {
//         int[] answer = new int[queries.length];

//         int[][] arr = new int[rows][columns];
//         int pos = 1;
//         for(int i=0; i<rows; i++){
//             for(int j=0; j<columns; j++){
//                 arr[i][j] = pos++;
//             }
//         }

//         List<Integer> list = new ArrayList<Integer>();
//         for(int T=0; T<queries.length; T++){
//             list.add( move(arr, queries[T]) );
//         }

//         for(int i=0; i<answer.length; i++){
//             answer[i] = list.get(i);
//         }

//         return answer;
//     }

//     private int move(int[][] arr, int[] queries) {

//         int sy = queries[0] - 1;
//         int sx = queries[1] - 1;
//         int ey = queries[2] - 1;
//         int ex = queries[3] - 1;
//         int ny = queries[0] - 1;
//         int nx = queries[1] - 1;

//         int[] dx = { 1, 0, -1, 0 };
//         int[] dy = { 0, 1, 0, -1 };

//         int min = Integer.MAX_VALUE;
//         int tmp1 = 0, tmp2 = arr[ny][nx], dic = 0;        
//         while( true ){

//             if( ( dic == 0 && nx == ex ) || ( dic == 1 && ny == ey ) || ( dic == 2 && nx == sx ) ){
//                 dic++;
//                 continue;
//             }else if( dic == 3 && ny == sy ){
//                 break;
//             }
     

//             tmp1 = tmp2;
//             tmp2 = arr[ny+dy[dic]][nx+dx[dic]];
//             arr[ny+dy[dic]][nx+dx[dic]] = tmp1;

//             min = Math.min(tmp1, min);

//             ny = ny+dy[dic];
//             nx = nx+dx[dic];
//         }


//         return min;
//     }
// }