package sort;

/**
 * Created by orca on 2018/12/14.
 * 冒泡排序:最好O(n) 最坏O(n^2) 平均O(n^2)
 *
 * */
public class BubbleSort {
    public static void sort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            int flag = 0;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = 1;
                }
                if (flag == 0) {
                    break;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
