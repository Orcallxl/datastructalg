//package algo.array;
//
///**
// * Created by orca on 2020/5/24.
// */
//public class Kafoul {
//    public static void main(String args[]){
//
//        merge();
//    }
//
//    public int[][] merge(int[][] intervals) {
//        int[][] new_intervals = new int[][]{};
//        int index=0;
//        for(int i =0;i<intervals.length-1;i++){
//            for(int j=i+1;j<intervals.length;j++){
//                if(intervals[1][i]>intervals[0][j]&&intervals[1][i]<intervals[1][j]){
//                    new_intervals[0][index] = intervals[0][i];
//                    new_intervals[1][index] = intervals[1][i];
//                    index++;
//                }
//            }
//        }
//       return new_intervals;
//    }
//}
