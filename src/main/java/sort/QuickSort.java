package sort;

/**
 * Created by orca on 2018/12/16.
 * 注意自测的测试用例要覆盖完全,边界情况一定要考虑清楚，脑子里要有各种奇葩的测试用例保证程序正确性。+
 * 最好 最坏 平均 不稳定
 * 元：比pivot小的移动到pivot左边大的移动到右边，而且不能增加空间复杂度。
 */
public class QuickSort {
    public static void sort(int[] o){
        quickSort(o,0,o.length-1);
    }
    public static void quickSort(int[] o,int start,int end){
        if(start>=end){
            return;
        }
        int pivot = partition(o,start,end);

        quickSort(o,start,pivot-1);
        quickSort(o,pivot+1,end);
    }

    //极客时间中的写法在partition2方法中
    private static int partition(int[] o, int start, int end) {
        int pivot =start;
        int i = start;
        int j = end;
        int tmp;
        while(i<j){
            //子循环1一定在子循环2之前，才能保证主循环结束后o[i]<o[pivot]
            //子循环1
            while(j>i&&o[j]>=o[pivot]){
                j--;
            }
            //子循环2
            while(i<j&&o[i]<=o[pivot]){
                i++;
            }
            if(i<j){
                tmp = o[i];
                o[i] = o[j];
                o[j] = tmp;
            }
        }
        tmp = o[i];
        o[i] = o[pivot];
        o[pivot] = tmp;
        return i;
    }

    public static void main(String args[]){
        int[] a = {1,2,3,2,1,2,3,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
