package algo.backtracking;

/**
 * Created by orca on 2018/12/28.
 * 问题：八皇后问题
 * 元：用递归实现回溯（递归实现暴力穷举）
 */
public class EightQueensPuzzle {
    public int[] result = new int[8];
    public static int num = 0;

    public void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int col = 0; col < 8; col++) {
            if(isOk(row,col)){
                result[row] = col;
                cal8queens(row+1);
            }
        }

    }

    private boolean isOk(int row, int col) {
        int leftUp = col-1;int rightUp = col+1;
        for(int i = row-1;i>=0;i--){
            if(result[i] ==col) return false;
            if(result[i] ==leftUp) return false;
            if(result[i] == rightUp) return false;
            leftUp--; rightUp++;
        }
        return true;
    }

    private void printQueens(int[] result) {
       num++;
        for(int i = 0;i<result.length;i++){
            for(int j =0;j<8;j++){
                if(result[i]==j){
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[]){
        EightQueensPuzzle puzzle = new EightQueensPuzzle();
        puzzle.cal8queens(0);
        System.out.print("共有解法："+num+"种");
    }
}
