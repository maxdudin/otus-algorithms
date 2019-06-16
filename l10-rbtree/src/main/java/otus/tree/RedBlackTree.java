package otus.tree;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<K extends Comparable<K>, V> {
    public static final boolean RED = false;
    public static final boolean BLACK = true;

    public class TreeNode {
        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
        TreeNode parent;
        TreeNode left = null;
        TreeNode right = null;
        List<TreeNode> equalElements = new ArrayList<TreeNode>();
        boolean color = RED;
        boolean deleted = false;
        boolean isLeftChild = false;
    }

    private TreeNode root;

    public void insert(TreeNode node) {
        if (root == null) {
            root = node;
            node.color = BLACK;
            return;
        }

        insert(root, node);
    }

    private void insert(TreeNode subTree, TreeNode node) {
        if (node.key.compareTo(subTree.key) < 0) {

            if (subTree.left == null) {
                subTree.left = node;
                node.parent = subTree;
                node.isLeftChild = true;
                checkColor(node);
                return;
            }

            insert(subTree.left, node);
        } else if (node.key.compareTo(subTree.key) > 0) {
            if (subTree.right == null) {
                subTree.right = node;
                node.parent = subTree;
                node.isLeftChild = false;
                checkColor(node);
                return;
            }

            insert(subTree.right, node);
        } else {
            subTree.equalElements.add(node);
        }
    }

    private void checkColor(TreeNode node) {
        TreeNode parent = node.parent;

        if (parent == null) {
            root = node;
            node.color = BLACK;
            return;
        }

        TreeNode grandParent = parent.parent;
        if (grandParent == null) {
            return;
        }

        if (node.color == RED && parent.color == RED) {
            TreeNode aunt = parent.isLeftChild ? grandParent.right : grandParent.left;
            if (aunt != null && aunt.color == RED) {
                parent.color = BLACK;
                grandParent.color = RED;
                aunt.color = BLACK;
            } else {

                if (parent.isLeftChild) {
                    if (node.isLeftChild) {
                        leftLeftCase(grandParent);
                    } else {
                        leftRightCase(grandParent);
                    }

                } else {
                    if (node.isLeftChild) {
                        rightLeftCase(grandParent);
                    } else {
                        rightRightCase(grandParent);
                    }

                }
            }
        }

        checkColor(parent);
    }
}
