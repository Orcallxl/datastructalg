package datastruct.tree;

/**
 * Created by orca on 2018/12/26.
 * 字典树
 * 应用场景：前缀匹配字符串如搜索引擎的关键词提示功能。字符串搜索更适合使用红黑树或散列表。
 * 瓶颈：内存消耗。
 *
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    //构建（一个个插入） 时间复杂度：O（n）
    public void insert(char[] text){
        TrieNode p = root;
        for(int i = 0;i<text.length;i++){
            int index = text[i]-'a';
            if(p.children[index]==null){
                p.children[index] = new TrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    //查找 时间复杂度O（pattern.length）
    public boolean find(char[] pattern){
        TrieNode p = root;
        for(int i = 0 ;i<pattern.length;i++){
            int index = pattern[i]-'a';
            if(p.children[index]==null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndingChar==true){
            return true;
        }
        else{
            return false;
        }
    }

    public class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("he".toCharArray());
        trie.insert("nothing".toCharArray());
        trie.insert("no".toCharArray());
        System.out.print(trie.find("no".toCharArray()));
    }

}
