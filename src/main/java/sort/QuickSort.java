package sort;

/**
 * Created by orca on 2018/12/16.
 * 注意自测的测试用例要覆盖完全,边界情况一定要考虑清楚，脑子里要有各种奇葩的测试用例保证程序正确性。+
 * 最好nlogn 最坏n^2 平均nlogn 不稳定
 * 元：分区函数(如何把一段数字按某个数大小分成两段)。分区函数2用到了“数组O(1)插入”的思想。
 */
public class QuickSort {
    public static void sort(int[] o) {
        quickSort(o, 0, o.length - 1);
    }

    public static void quickSort(int[] o, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition3(o, start, end);//分区函数的第二种写法（更好），来自极客时间
        //int pivot = partition(o, start, end);//分区函数的第一种写法
        quickSort(o, start, pivot - 1);
        quickSort(o, pivot + 1, end);
    }

    //极客时间中的写法在partition2方法中
    private static int partition(int[] o, int start, int end) {
        int pivot = start;
        int i = start;
        int j = end;
        int tmp;
        while (i < j) {
            //子循环1一定在子循环2之前，才能保证主循环结束后o[i]<o[pivot]
            //子循环1
            while (j > i && o[j] >= o[pivot]) {
                j--;
            }
            //子循环2
            while (i < j && o[i] <= o[pivot]) {
                i++;
            }
            if (i < j) {
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

    private static int partition3(int[] o, int start, int end){
        int pivot = end;
        int j = start;
        int tmp;
        for(int i = start;i<=end;i++){
            if(o[i]<o[pivot]){
                tmp = o[j];
                o[j] = o[i];
                o[i] = tmp;
                j++;
            }
        }
        tmp = o[pivot];
        o[pivot] = o[j];
        o[j] = tmp;
        return j;
    }

    //这里分区算法十分巧妙，多写多看
    private static int partition2(int[] o, int start, int end) {
        int pivot = start;
        int i = end;
        int tmp;
        ///=int j = end;
        for (int j = end; j >= start+1; j--) {//极客时间写的是正的，我写成反的了，其实不利于阅读
            if (o[j] > o[pivot]) {
                tmp = o[i];
                o[i] = o[j];
                o[j] = tmp;
                i--;
            }
        }
        tmp = o[i];
        o[i] = o[pivot];
        o[pivot] = tmp;
        return i;


    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
