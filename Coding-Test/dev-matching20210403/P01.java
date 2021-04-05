// import java.util.*;

// public class P01 {
    
//     public static void main(String[] args){
//         Solution s = new Solution();

//         int[] lottos = { 44, 1, 0, 0, 31, 25 };
//         int[] win_nums = { 31, 10, 45, 1, 6, 19 };

//         System.out.println( s.solution( lottos, win_nums ) );
//     }
// }

// class Solution {
//     public int[] solution(int[] lottos, int[] win_nums) {

//         Arrays.sort(lottos);
//         Arrays.sort(win_nums);

//         int min = fun( lottos, win_nums);
//         int zero = findZero( lottos );
        
//         if( min < 2 ){
//             min = 6;
//             zero = handle( min, zero );
//         }else if( min == 2 ){
//             min = 5;
//             zero = handle( min, zero );
//         }else if( min == 3 ){
//             min = 4;
//             zero = handle( min, zero );
//         }else if( min == 4 ){
//             min = 3;
//             zero = handle( min, zero );
//         }else if( min == 5 ){
//             min = 2;
//             zero = handle( min, zero );
//         }else if( min == 6 ){
//             min = 1;
//             zero = handle( min, zero );
//         }

//         int[] answer = {zero, min};
//         return answer;
//     }

//     private int handle(int min, int zero) {        
//         if( zero == 0 ){
//             zero = min;
//         }else if( zero == 1 ){
//             zero = min - 1;                
//         }else if( zero == 2 ){
//             zero = min - 2;
//         }else if( zero == 3 ){
//             zero = min - 3;
//         }else if( zero == 4 ){
//             zero = min - 4;
//         }else if( zero == 5 ){
//             zero = min - 5;
//         }else if( zero == 6 ){
//             zero = 1;
//         }
//         return zero;
//     }

//     private int findZero(int[] lottos) {
//         int count = 0;
//         for(int i=0; i<lottos.length; i++){
//             if( lottos[i] == 0 ){
//                 count++;
//             }
//         }
//         return count;
//     }

//     private int fun(int[] lottos, int[] win_nums) {

//         Set<Integer> l = new HashSet<Integer>();
//         Set<Integer> w = new HashSet<Integer>();
        
//         for(int i=0; i<lottos.length; i++){
//             if( lottos[i] != 0 ){
//                 l.add(lottos[i]);
//             }            
//         }

//         for(int i=0; i<win_nums.length; i++){
//             w.add(win_nums[i]);
//         }

//         int count = 0;
//         for(int i : l){
//             if( w.contains(i) ){
//                 count++;
//             }
//         }

//         return count;
//     }
// }