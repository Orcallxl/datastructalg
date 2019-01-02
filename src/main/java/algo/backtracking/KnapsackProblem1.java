package algo.backtracking;

/**
 * Created by orca on 2019/1/2.
 * 问题:0-1背包问题，一维数组动态规划解决问题。
 * 复杂度：
 */
public class KnapsackProblem1 {
    public int n;
    public int w;
    public boolean[] mem;

    public KnapsackProblem1(int n, int w) {
        this.n = n;
        this.w = w;
        mem = new boolean[w + 1];
    }


    public void f(int[] items, int w) {
        mem[0] = true;
        mem[1] = true;
        for (int n = 1; n < items.length; n++) {
            for (int m = w-items[n]; m > 0 ; m--) {
                if(mem[m]==true) mem[m+items[n]] = true;
            }
        }
        for(int i = mem.length-1;i>0;i--){
            if(mem[i]==true){
                System.out.println("最大重量："+i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        KnapsackProblem1 problem = new KnapsackProblem1(5, 10);
        problem.f(in, 10);
    }
}
