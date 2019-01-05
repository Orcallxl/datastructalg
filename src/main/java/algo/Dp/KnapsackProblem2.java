package algo.Dp;

import java.util.Arrays;

/**
 * Created by orca on 2019/1/2.
 *  问题:0-1背包问题升级版,背包:items 对应价值:values,最大重量限制w。
 *
 */
public class KnapsackProblem2 {
    public static int items[] = {2,2,4,6,3};//物品重量
    public static int values[] = {3,4,8,9,6};//价值
    public static int w = 9;//最大重量
    public static int mem[][] = new int[5][10];
    public static int mv = 0;//最大价值
    public static void main(String args[]){
        //初始化
        for(int c = 0 ;c<mem.length;c++) {
            Arrays.fill(mem[c],-1);//源代码也是用的for循环填充所以用双重for没什么区别
        }
        mem[0][0] = 0;
        mem[0][2] = 3;
        for(int i = 1;i<items.length;i++){
            //放
            for(int j = 0;j<=w-items[i];j++){
                if(mem[i-1][j]>=0) {
                    int v = mem[i-1][j]+values[i];
                    if(v>mem[i][j+items[i]])
                        mem[i][j+items[i]] = v;
                }
                if(mv<mem[i][j+items[i]]){
                    mv = mem[i][j+items[i]];
                }
            }
            //不放
            for(int j = 0;j<mem[i].length;j++){
                if(mem[i-1][j]>=0) {
                    mem[i][j] = mem[i-1][j];
                }
            }
        }
        System.out.println("最大价值："+mv);
        for(int k = w ;k>=0;k--){
            if(mem[items.length-1][k]>0) {System.out.println("最大价值："+mem[items.length-1][k]);break;}
        }
        //回溯出被选中的物品
        for(int i = items.length-1;i>0;i--){
            if(mem[i-1][w-items[i]]==mem[i][w]-values[i]) {
                System.out.println("装入第"+i+"个物品");
                w = w- items[i];
            }
            else{

            }
        }
        if(mem[0][w]>0){System.out.println("装入第"+0+"个物品");}

    }
}
