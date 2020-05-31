package problem.palindrome;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * Created by orca on 2020/5/27.
 * 核心问题：
 *      如何计算一个numer的revertedNu/mer
 */
public class PalindromeNumber {
    static class Solution{
        public boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }
            int next = x;
            int num = 0;
            while(next>num){
                num = num*10 + next%10;
                next = next/10;
            }
            return num == next || num/10 == next?true:false;
        }
    }
    public static void main(String args[]){
        System.out.println(new Solution().isPalindrome(123454321));
    }

}
