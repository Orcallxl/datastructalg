package problem;

/**
 * Created by orca on 2018/12/11.
 *测试java的引用问题：
 * a->obja,b->objb,c->a
 * 把a->b那么c还是指向a之前指向的对象，不会跟a一起跑
 * c语言不知道会怎么样。
 */
public class TestMain {
    public static void main(String args[]){
        Strudent a = new Strudent("xia","1");
        Strudent b = new Strudent("luo","2");
        Strudent c = a;
        a = b;
        Strudent d = new Strudent("tang","3");
        Strudent e = d;
        d = null;
        System.out.println(a.getName());//luo
        System.out.println(c.getName());//xia
        System.out.println(e.getName());//tang
    }
}
