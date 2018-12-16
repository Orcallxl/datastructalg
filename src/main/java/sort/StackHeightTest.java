package sort;

/**
 * Created by orca on 2018/12/15.
 * 检测最大栈深度
 * stackOverFlow和OOM都是属于Error
 */
public class StackHeightTest {
    public static int i =0;
    public static void height(){
        i++;
        height();
    }
    public static void main(String args[]){
        try {
            height();
        }
        catch (Throwable e){
            System.out.println("Stack Height:"+i);
        }
    }
}
