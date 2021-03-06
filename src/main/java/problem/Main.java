package problem;

import sun.awt.geom.AreaOp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by orca on 2018/12/9.
 * 自己写的计算器BasicCaculator的入口
 * 知识点1：java输入流 System.in代表着控制台实体
 */
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner xx = new Scanner( System.in );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BasicCaculator caculator = new BasicCaculator();
        String input;
        while((input = br.readLine())!=null){
            int result =  caculator.caculate(input);
            System.out.println(result);
        }
//        LRUCache cache = new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        System.out.println(cache.get(1));
//        cache.put(3,3);
//        System.out.println(cache.get(2));
//        cache.put(4,4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
