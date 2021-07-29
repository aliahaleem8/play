//import java.util.ArrayList;
//import java.util.List;
//
public class Cell {
//
//        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
//        public List<Integer> cellCompete(int[] states, int days)
//        {
//            int[][] values = new int[2][8];
//            int x = 0;
//            for (int i=0; i<=days; i++){
//                // cover edge cases first
//                if (states[1]==0){
//                    values[x][0] = 1 ;
//                }
//                else values[x][0] = 0 ;
//
//
//                // do the middle cases by checking both side values
//                for (int j = 1; j<=7 ; j++){
//                    if (states[j-1] == states[j+1]){
//                        values[x][j]=1;
//                    }
//                    else values[x][j]=0;
//
//                }
//
//                // do the last edge case
//                if (states[states.length()-2]==0){
//                    values[x][states.length-1] = 1 ;
//                }
//                else  values[x][states.length-1] = 0 ;
//
//
//            }
//
//            return values[x][]
//        }
//        // METHOD SIGNATURE ENDS
//        //[1: active; 0: inactive ]
//        // 0 x 0  / 1 x 1  ==> x = 0 next day, else x=1
//        // [x, 0  / [x , 1  == > 0 x 1 / 0 x 1 == left edge house
//        //  0, x ] / 1, x ] ==>  0 x 0 / 1 x 0 == right edge house
//
}
