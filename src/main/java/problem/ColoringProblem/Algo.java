//package problem.ColoringProblem;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Set;
//import java.util.TreeSet;
//import java.util.*;
///**
// * Created by orca on 2018/12/12.
// */
//public class Algo {
//
//
//
//
//        //集合u
//        TreeSet<Node> u = new TreeSet<>(Comparator.comparingInt(o -> o.l_uncolor));
//        //集合Ci
//        HashMap<Integer, Node> ci = new HashMap<>();
//
//        //节点数据结构
//        class Node {
//
//            int id;
//            int color;
//            int l_uncolor;
//            Set<Integer> set;
//
//            private Node(int id) {
//                this.id = id;
//            }
//
//
//            private void draw(int color) {
//                this.color = color;
//            }
//
//            @Override
//            public int hashCode() {
//                return this.id;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//
//            public void add(Integer id) {
//                this.set.add(id);
//            }
//        }
//
//        //初始化
//        public String begin(String input) {
//
//
//            for (int i = 0; i < input.length()-1;i++){
//                //节点加入u集合
//                if(input.substring())
//            }
//
//            for (int row = 0; row <= inputRow; row++) {
//                int currentId;
//                Node node;
//                int lnodeId;
//
//                //更新关系
//                node.set.add(lnodeId);
//
//                node.l_uncolor++;
//
//                //新节点加入u集合
//                if (true) {
//                    currentId = 0;
//                    node = new Node(currentId);
//                    u.add(node);
//                }
//            }
//        }
//
//        public void process(TreeSet<Node> u, HashMap<Integer, Node> ci) {
//            while (u.size() != 0) {
//                int i = 0;
//                sort(u);
//                color(i, u, ci);
//                i++;
//            }
//        }
//
//        private void color(int i, TreeSet<Node> u, HashMap<Integer, Node> ci) {
//            Iterator iterator = u.iterator();
//            while (iterator.hasNext()) {
//                Node node = (Node) iterator.next();
//                node.color = i;
//
//                //从u中删除
//                u.remove(node);
//
//                //加入ci
//                ci.put(i, node);
//
//                //邻接点着色--(排序依据)
//                Iterator nodeIterator = node.set.iterator();
//                while (nodeIterator.hasNext()) {
//                    Node l_node = (Node) nodeIterator.next();
//                    l_node.l_uncolor--;
//                }
//            }
//        }
//
//
//        public TreeSet<Node> sort(TreeSet<Node> set) {
//            TreeSet<Node> newSet = new TreeSet<>();
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                Node node = (Node) iterator.next();
//                newSet.add(node);
//            }
//            return newSet;
//        }
//    }
//
