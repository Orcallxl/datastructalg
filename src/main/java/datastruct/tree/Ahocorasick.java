package datastruct.tree;

/**
 * Created by orca on 2018/12/26.
 * Ac自动机,Trie的升级版
 * 应用场景：多模式字符串匹配
 */
public class Ahocorasick {
    public class AcNode{
        public char data;
        public AcNode[] children = new AcNode[26];
        public boolean isEndingChar = false;
        public int length = -1;
        public AcNode fail;
        public AcNode(char data){
            this.data = data;
        }
    }
}
