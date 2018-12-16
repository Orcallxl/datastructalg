package sort.problem;

/**
 * Created by orca on 2018/12/17.
 * 问题：从一堆无序数组中找出第k大的数,时间复杂度为n
 */
public class FindKnumber {
    public static void main(String args[]){
        int k = 5;
        int result;
        int[] o = {1,2,3,4,3,2,1};
        result = findK(o,k-1,0,o.length-1);
        System.out.println("第"+k+"大的数是："+o[result]);
    }

    private static int findK(int[] o,int k,int p,int r) {
        int pivot = partition(o,p,r);
        if(pivot==k){
           return k;
        }
        else if(pivot>k){
            return  findK(o,k,p,pivot-1);
        }
        else{
            return  findK(o,k,pivot+1,r);
        }
    }

    private static int partition(int[] o, int p, int r) {
        int i = p;
        int pivot = r;
        int tmp;
        for(int j = p;j<=r-1;j++){
            if(o[j]<o[pivot]){
                tmp = o[i];
                o[i] =o[j];
                o[j] = tmp;
                i++;
            }
        }
        tmp = o[i];
        o[i] = o[pivot];
        o[pivot] = tmp;
        return  i;
    }

}
