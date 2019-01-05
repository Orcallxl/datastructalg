package algo.Dp;


import algo.Main;

/**
 * Created by orca on 2019/1/5.
 */
public class LwstProblem {
    public static String a = "mitcmu";
    public static String b = "mtacnu";
    public static int min = Integer.MAX_VALUE;

    public static int lwstDP(char[] a, char[] b) {
        int[][] minDist = new int[a.length][b.length];
        int i;
        int j;
        for (j = 0; j < b.length; j++) {
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            else minDist[0][j] = 1;
        }
        for (i = 0; i < a.length; i++) {
            if (b[0] == a[i]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }
        for (i = 1; i < a.length; i++) {
            for (j = 1; j < b.length; j++) {
                if (a[i] == b[j]) minDist[i][j] = min(minDist[i - 1][j] , minDist[i][j - 1] , minDist[i - 1][j - 1]);
                else minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }

        }
        Main.printMatrix(minDist);
        return minDist[a.length - 1][b.length - 1];
    }
    //回溯解法
    public static void lwstBT(char[] as,char[] bs,int i , int j , int editdist){
        if(i==a.length()||j==b.length()) {
            if (i == a.length() ) editdist = editdist + b.length() - j;
            if (j == b.length() ) editdist = editdist + a.length() - i;
            if (editdist < min) min = editdist;
            return;
        }
        if(as[i]==bs[j]) lwstBT(as,bs,i+1,j+1,editdist);
        else {
            lwstBT(as,bs,i+1,j,editdist+1);
            lwstBT(as,bs,i,j+1,editdist+1);
            lwstBT(as,bs,i+1,j+1,editdist+1);
        }
    }

    private static int min(int i, int i1, int i2) {
        int min = Integer.MAX_VALUE;
        if (i < min) min = i;
        if (i1 < min) min = i1;
        if (i2 < min) min = i2;
        return min;
    }

    public static void main(String args[]) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        System.out.println("莱温斯坦距离，dp解法，答案：" + lwstDP(as, bs));
        lwstBT(as, bs,0,0,0);
        System.out.println("莱温斯坦距离，bt解法，答案：" + min);
    }
}
