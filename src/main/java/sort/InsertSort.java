package sort;

/**
 * Created by orca on 2018/12/14.
 * 外循环如果要用到内循环的数组下标怎么办？下标变量的初始化挪出来
 * 平均时间复杂度On^2 最好时间复杂度On 平均O(n^2) 稳定
 */
public class InsertSort {
    public static void sort(int[] o){
        for(int i = 1 ; i<o.length;i++){
            int tmp = o[i];
            int j = i-1;
            for(; j>=0 ;j--){
                if(tmp<o[j]){
                    o[j+1] = o[j];
                }
                else{
                    break;
                }
            }
            o[j+1] = tmp;
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
