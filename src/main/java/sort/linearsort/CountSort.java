package sort.linearsort;

import java.util.Arrays;

/**
 * Created by orca on 2018/12/18.
 * 计数排序。桶排序的特殊情况。
 * 元：1-桶排序，计数
 * 时间复杂度：On 空间复杂度Ok （n是被排序元素的个数，k是被排序元素数据范围） 稳定
 * 使用场景：时间复杂度需求较高，有充足的内存提供使用，数据范围不大(比如电话号码排序不适合计数排序，引出另一种排序基数排序)
 */
public class CountSort {
    public static void main(String args[]) {
        int[] a = {6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 12, 2};
        int[] result = sort(a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] sort(int[] o) {
        //这里写o.length是不严谨的，应该是分组在最大值+1
        int[] c = new int[o.length];
        Arrays.fill(c, 0);
        int[] result = new int[o.length];

        //累加
        for (int i = 0; i < o.length; i++) {
            c[o[i]]++;
        }
        //计算出元素应该存在的位置
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        //attention!:!必须倒叙遍历O[i]才能保证算法的稳定性
        for (int i = o.length - 1; i >= 0; i--) {
            result[c[o[i]] - 1] = o[i];
            c[o[i]]--;
        }
        return result;
    }
}
