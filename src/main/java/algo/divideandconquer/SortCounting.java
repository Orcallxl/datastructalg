package algo.divideandconquer;

/**
 * Created by orca on 2018/12/27.
 * 解决的问题:求一组数据的逆序对个数
 * （整块代码的）元：归并排序+num计算你逆序度（逆序对的个数）
 * 算法分析（时空复杂度）：归并排序复杂度nlogn、n
 */
public class SortCounting {
    private int num = 0;

    public int count(int[] a) {
        num = 0;
        mergeSortCounting(a, 0, a.length - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (q - i + 1);
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for(int m =0;m<r-p+1;++m){
            a[p+m] = tmp[m];
        }
    }
    public static void main(String args[]){
        int[] a = {6,5,4,3,2,1,0};
        SortCounting sortCounting = new SortCounting();
        int degree = sortCounting.count(a);
        System.out.println("逆序度是："+degree);
        System.out.println("排序后的数组：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
