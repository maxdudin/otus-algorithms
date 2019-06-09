package otus.tree;

import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {
    private TreeNode root;

    private class TreeNode {
        K key;
        V node;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        List<TreeNode> equalElements;
        int balanceFactor;
        int height;
    }

    /**
     * Inserts a new node to a tree and does next operations:
     * 1. Looks for a place to insert a new node
     * 2. Updates nodes properties
     * 3. Does tree rebalancing
     * 4. Returns new tree root node
     * @param newNode
     * @return
     */
    public TreeNode insert(TreeNode newNode) {
        if (root == null) {
            root = newNode;
//            dostuff;
        }

        return insert(root, newNode);
    }

    private TreeNode insert(TreeNode subTree, TreeNode node) {

        if (node.key.compareTo(subTree.key) < 0) {

            if (node.left == null) {

            } else {
                node.left = insert(node.left, node);
            }


        } else if (node.key.compareTo(subTree.key) > 0) {

            if (node.right == null) {

            } else {
                node.right = insert(node.right, node);
            }

        } else {
            subTree.equalElements.add(node);
            return subTree;
        }

        updateHeight(node);
        return balance(node);
    }

    public void findPlaceToInsert(TreeNode newNode) {
//        TreeNode iterNode = root;
//
//        while (iterNode != null) {
//            if (newNode.key.compareTo(iterNode.key) < 0) {
//                if (iterNode.left == null) {
//                    newNode.parent = iterNode;
//                    newNode.height = 0;
//                    newNode.balanceFactor = 0;
//                    iterNode.left = newNode;
//                    height
//                    return;
//                }
//
//                iterNode = iterNode.left;
//            } else if (newNode.key.compareTo(iterNode.key) > 0) {
//                if (iterNode.right == null) {
//                    newNode.parent = iterNode;
//                    newNode.height = 0;
//                    newNode.balanceFactor = 0;
//                    iterNode.right = newNode;
//                    height
//                    return;
//                }
//
//                iterNode = iterNode.right;
//            } else {
//                iterNode.equalElements.add(newNode);
//                return;
//            }
//        }
    }

    private void updateHeight(TreeNode node) {
        int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
        int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private TreeNode balance(TreeNode node) {
        if (node.balanceFactor == -2) {
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }

        } else if (node.balanceFactor == 2) {
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }

        return node;
    }

    private TreeNode leftLeftCase(TreeNode node) {
        return rightRotation(node);
    }

    private TreeNode rightRightCase(TreeNode node) {
        return leftRotation(node);
    }

    private TreeNode leftRightCase(TreeNode node) {

    }

    private TreeNode rightLeftCase(TreeNode node) {

    }

    private TreeNode rightRotation(TreeNode node) {

    }

    private TreeNode leftRotation(TreeNode node) {

    }
}
