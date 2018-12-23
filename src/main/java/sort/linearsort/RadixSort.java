package sort.linearsort;

/**
 * Created by orca on 2018/12/20.
 *
 * 基数排序。
 * 元：把数据分割成多位，对每一位做计数排序。
 * */
public class RadixSort {
    public static void main(String args[]){
        int[] a = {6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 12, 2};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void sort(int[] o){

    }
}
