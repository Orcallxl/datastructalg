package algo.backtracking;

/**
 * Created by orca on 2018/12/29.
 * 问题：0-1背包问题，用二维数组动态规划解决问题。
 * 复杂度：时间为mostW*pack.length（双重循环二维数组长*宽）
 * 优化：一维数组解决 {@code KnapsackProblem1}
 * 待解决：这里只能打印出最优重量，怎么打印出具体用了哪几个物品填满背包？
 */
public class KnapsackProblem0 {
    public static int[] pack = {2, 2, 4, 6, 3};
    public static int mostW = 9;
    public static boolean w[][] = new boolean[pack.length][mostW + 1];
    public static int maxW = Integer.MIN_VALUE;
    public static int cw = 0;//


    public static void knapsack() {
        w[0][0] = true;
        w[0][pack[0]] = true;
        for (int m = 1; m < w.length; m++) {
            //放
            for (int n = 0; n < w[m].length; n++) {
                if (w[m - 1][n] == true) {
                    if (n + pack[m] <= mostW) {
                        if (maxW < n + pack[m]) {
                            maxW = n + pack[m];
                        }
                        w[m][n + pack[m]] = true;
                    }
                }
            }
            //不放
            for (int n = 0; n < w[m].length; n++) {
                if (w[m - 1][n] == true) {
                    w[m][n] = true;
                }
            }
        }
        return;
    }

//    //knapsack0从空间上进行优化
//    public static void knapsack0(){
//        for(int i =1 ;i<w.length;i++){
//            for(int j =mostW-pack[i];j>)
//        }
//    }

    public static void main(String args[]) {
        knapsack();
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i].length; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("最大重量："+maxW);
    }
}

