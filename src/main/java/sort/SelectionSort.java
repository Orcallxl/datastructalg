package sort;

/**
 * Created by orca on 2018/12/14.
 * 最好On 最坏On^2 平均On^2 不稳定
 */
public class SelectionSort {
    public static void sort(int[] o){
        int tmp ;
        for(int j=0;j<o.length-2;j++){
            int min = o.length-1;
            for(int i=o.length-1;i>j;i--){
                if(o[min]>o[i-1]){
                    min = i-1;
                }
            }
            tmp = o[j];
            o[j] = o[min];
            o[min] = tmp;
        }
    }
    public static void main(String args[]){
        int[] a = {6,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
