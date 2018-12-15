package problem;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by orca on 2018/12/11.
 * stack practice
 * https://leetcode.com/problems/basic-calculator/
 * 自己写的一个基于栈实现的计算器，包括了+-* \/ 和括号运算.leetcode的题只需要+-运算。
 */
public class BasicCaculator {
    public int caculate(String s) {
        Stack stack = new Stack();
        Stack stack0 = new Stack();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        map.put(")", -1);
        map.put("(", -1);
        int i =0;
        while(i<s.length()) {
            String now = s.substring(i, i + 1);
            if (now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/")) {
                while ((!stack.isEmpty()) && map.get(now) <= map.get(stack.elementAt(stack.size()-1))) {
                    if(stack.elementAt(stack.size()-1).equals("(")){
                        break;
                    }
                    Integer right = Integer.valueOf(stack0.pop().toString());
                    Integer left = Integer.valueOf(stack0.pop().toString());
                    String op = (String) stack.pop();
                    Integer result;
                    if (op.equals("+")) {
                        result = left + right;
                        stack0.push(result);
                    } else if (op.equals("-")) {
                        result = left - right;
                        stack0.push(result);
                    } else if (op.equals("*")) {
                        result = left * right;
                        stack0.push(result);
                    } else if (op.equals("/")) {
                        result = left / right;
                        stack0.push(result);
                    }

                }
                stack.push(now);
            }
            while(now.matches("[0-9]*")&&(i+2 <= s.length())&&(s.substring(i+1,i+2).matches("[0-9]"))){
                now = now + s.substring(i+1,i+2);
                i++;
            }
            if (now.equals(" ")) {
                continue;
            }
            if (!(now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/") || now.equals("(") || now.equals(")"))) {
                stack0.push(now);
            }
            if (now.equals("(") || now.equals(")")) {
                if (now.equals("(")) {
                    stack.push(now);
                }
                if (now.equals(")")) {
                    String op0;
                    while (!(op0 = (String) stack.pop()) .equals("(")) {
                        Integer right = Integer.valueOf(stack0.pop().toString());
                        Integer left = Integer.valueOf(stack0.pop().toString());
                        String op = op0;
                        Integer result;
                        if (op.equals("+")) {
                            result = left + right;
                            stack0.push(result);
                        } else if (op.equals("-")) {
                            result = left - right;
                            stack0.push(result);
                        } else if (op.equals("*")) {
                            result = left * right;
                            stack0.push(result);
                        } else if (op.equals("/")) {
                            result = left / right;
                            stack0.push(result);
                        }
                    }
                }
            }



            i++;
        }
        while (!stack.isEmpty()) {
            Integer right = Integer.valueOf(stack0.pop().toString());
            Integer left = Integer.valueOf(stack0.pop().toString());
            String op = (String) stack.pop();
            Integer result;
            if (op.equals("+")) {
                result = left + right;
                stack0.push(result);
            } else if (op.equals("-")) {
                result = left - right;
                stack0.push(result);
            } else if (op.equals("*")) {
                result = left * right;
                stack0.push(result);
            } else if (op.equals("/")) {
                result = left / right;
                stack0.push(result);
            }
        }


            return Integer.parseInt(stack0.pop().toString());
        }
    }

