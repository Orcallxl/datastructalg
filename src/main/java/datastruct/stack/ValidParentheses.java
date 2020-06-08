package datastruct.stack;

import java.util.Stack;

/**
 * Created by orca on 2020/6/8.
 * 问题：
 *  1java字符串如何变成字符数组-->可以charAt直接遍历
 *  2java的栈用哪一个数据结构---》Stack
 *  3边界条件：stack为空peek方法会报错
 *  引申：
 *  对称的问题可以用栈
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    static class Solution{
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();
            for(int i=0;i<s.length();i++){
                Character cur = s.charAt(i);
                if(cur.equals('[')||cur.equals('{')||cur.equals('(')){
                    stack.push(cur);
                }
                else if(!stack.isEmpty()&&needPop(stack.peek(), cur)){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            if (!stack.isEmpty()){
                return false;
            }
            return true;
        }
        public static boolean needPop(Character pre, Character cur){
            return (pre.equals('{')&&cur.equals('}'))|| (pre.equals('(')&&cur.equals(')')) || (pre.equals('[')&&cur.equals(']'));
        }
    }
    public static void main(String args[]){
        String test = "({[(])})";
        Solution solution = new Solution();
        boolean result = solution.isValid(test);
        System.out.print(result);
    }

}
