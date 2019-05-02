package sort;

import datastruct.SkipList;

/**
 * Created by orca on 2018/12/14.
 * 归并排序的元：“归”+“并”，“并”的本质是“分段有序”下的排序算法
 * 时间复杂度稳定，都是nlogn，空间复杂度0(n)
 * 要记住的编程细节元：mid=start+(end-start)/2,count=end-start+1
 * 编程书写规范：tmp[index++] = o[j++];比写成tmp[index] =o[j++];index++;j++;更好
 */
public class MergeSort {
    public static void sort(int[] o) {
        int start = 0;
        int end = o.length - 1;
        sort0(o, start, end);
    }

    public static void sort0(int[] o, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort0(o, start, mid);
        sort0(o, mid + 1, end);
        optMerge(o, start, mid, end);
    }

    //使用哨兵进行优化
    private static void optMerge(int[] o, int start, int mid, int end){
        int[] left = new int[mid-start+2];
        int[] right = new int[end-mid+1];
        System.arraycopy(o,start,left,0,mid-start+1);
        System.arraycopy(o,mid+1,right,0,end-mid);
        left[mid-start+1] = 99999;//max
        right[end-mid] = 99999;
        int i = 0;
        int j = 0;
        int k = start;
        while(left[i]!=99999){
            if(left[i]<=right[j]){
                o[k] = left[i];
                i++;
            }
            else {
                o[k] = right[j];
                j++;
            }
            k++;
        }
    }

    //实际是找出“分段有序”下的最佳(On)合并算法
    private static void merge(int[] o, int start, int mid, int end) {
        //o[start..mid]与o[mid+1..end]拼接
        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (o[j] < o[i]) {
                tmp[index++] = o[j++];
            } else {
                tmp[index++] = o[i++];
            }
        }
        //剩余元素拷贝
        if (i == mid + 1) {
            while (j <= end) {
                tmp[index++] = o[j++];
            }
        }
        if (j == end + 1) {
            while (i <= mid) {
                tmp[index++] = o[i++];
            }
        }
        //tmp整体拷贝到原数组
        for (int m = 0; m < tmp.length; m++) {
            o[start + m] = tmp[m];
        }
    }

    public static void main(String args[]) {
        int[] a = {1,2,3,2,1,2,3,4,3,2,1,2,3,4,5,4,3,2,1,2,3,4,5,6,7,6,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
