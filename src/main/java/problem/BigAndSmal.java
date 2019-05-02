package problem;

/**
 * 问题：把字母序列分成大写和小写两块，不要求完全有序
 * 解决方法：快速排序的分区元思维
 * 扩展：分类问题或者整体有序问题都可以用分区函数
 * Created by orca on 2019/4/24.
 */
public class BigAndSmal {
    public static void main(String args[]){
        char[] alpha = {'a','C','b','D','e','F'};
        sort(alpha);
        for(int i = 0;i<=alpha.length-1;i++){
            System.out.println(alpha[i]);
        }
    }

    public static void sort(char[] chars){
        int j = 0;
        for(int i =1;i<=chars.length-1;i++){
            if(chars[i]>='a'&&chars[i]<='z'){
                char tmp = chars[j];
                chars[j] = chars[i];
                chars[i] = tmp;
                j++;
            }
        }
    }
}
