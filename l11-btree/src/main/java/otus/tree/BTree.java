package otus.tree;

import lombok.Setter;

public class BTree<K extends Comparable<K>> {
    private final int nodeSize;
    private BTreeNode root;

    public BTree(int nodeSize) {
        this.nodeSize = nodeSize;
    }

    public class BTreeNode {
        public BTreeNode() {
            keys = (K[]) new Object[nodeSize];
            childs = (BTreeNode[]) new Object[nodeSize + 1];
            isLeaf = true;
        }

        @Setter
        private K[] keys;

        @Setter
        private BTreeNode[] childs;

        @Setter
        private boolean isLeaf;
    }

    public void insert(K key) {
        if (root == null) {
            root = new BTreeNode();
        }

    }

//    public boolean search(K key) {
//
//    }
//
//    public K detete() {
//
//    }
}
