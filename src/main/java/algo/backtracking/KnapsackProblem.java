package algo.backtracking;


/**
 * Created by orca on 2018/12/28.
 * 问题：0-1背包问题，(01是指背包放还是不放):不超过总重量前提下背包中物品总重量最大，求出最大的重量和最优解集。用回溯解法解决问题。
 * 元：回溯法+裁枝优化+递归备忘录优化
 * 复杂度：时间为2^n （放与不放问题0-1问题指数级复杂度）原地算法。优化之后和动态规划解决方案的复杂度基本一样。
 * 建模编码技巧：递归问题都化递归树来描述递归过程更加清晰
 */
public class KnapsackProblem {
    public int n;
    public int w;
    public boolean[][] mem;

    public KnapsackProblem(int n, int w) {
        this.n = n;
        this.w = w;
        mem = new boolean[n][w + 1];
    }

    public static int maxW = Integer.MIN_VALUE;

    public void f(int i, int cw, int[] items, int n, int w) {
        if (i > n - 1 || cw > w) {
            return;
        }
        if (cw > maxW) {
            maxW = cw;
        }
        if (mem[i][cw]) {
            return;
        }
        mem[i][cw] = true;
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {//优化：裁枝
            f(i + 1, cw + items[i], items, n, w);
        }
    }


    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        KnapsackProblem problem = new KnapsackProblem(5, 10);
        problem.f(0, 0, in, 5, 10);

        System.out.println("最大重量：" + maxW);
    }
}
