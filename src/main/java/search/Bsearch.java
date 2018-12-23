package search;

/**
 * Created by orca on 2018/12/21.
 * 二分查找
 * 时间：logn 空间：n（数据本身占的内存）
 * 使用场景：
 * 相比较二叉树、散列表占用内存不大
 * 相比较顺序遍历查找时间优势大
 * 实际使用多的是二分查找的4个变种问题
 * 按具体环境进行选择
 */
public class Bsearch {
    public static void main(String args[]){
        int[] o = {1,2,3,4,5,6,7,8};
        int index = search(o,9,0,o.length-1);
        System.out.print(index);
    }

    public  static int search(int[] o,int a,int low,int high){
        int mid = low+(high-low)>>1;//极致优化，移位比除法更节省时间
        if(mid<low||mid>high){
            return -1;
        }
        if(a<o[mid]){
            return search(o,a,low,mid-1);
        }
        else if(a>o[mid]){
            return search(o,a,mid+1,high);
        }
        else{
            return mid;
        }

    }
}
