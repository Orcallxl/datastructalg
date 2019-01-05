package algo;

/**
 * Created by orca on 2018/12/27.
 *
 */
public class Main {

    public static void printMatrix(int[][] matrix){
        int i;
        for( i = 0 ;i<matrix.length;i++){
            for(int j = 0 ;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){

    }

}
