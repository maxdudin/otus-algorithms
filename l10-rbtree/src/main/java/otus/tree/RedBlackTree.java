package otus.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public TreeNode find(K key) {
        if (root == null) {
            return null;
        }

        return find(root, key);
    }

    private TreeNode find(TreeNode subTree, K key) {
        if (subTree.key.compareTo(key) < 0) {

            if (subTree.left == null) {
                return null;
            }

            return find(subTree.left, key);
        } else if (subTree.key.compareTo(key) > 0) {
            if (subTree.right == null) {
                return null;
            }

            return find(subTree.right, key);
        } else {
            return subTree;
        }
    }

    public void insert(TreeNode node) {
        if (root == null) {
            root = node;
            node.color = BLACK;
            return;
        }

        assert root.color == BLACK;
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

    private void swapColors(TreeNode a, TreeNode b) {
        a.color = a.color ^ b.color;
        b.color = a.color ^ b.color;
        a.color = a.color ^ b.color;
    }

    private TreeNode leftLeftCase(TreeNode node) {
        node = rightRotation(node);
        swapColors(node, node.right);
        return node;
    }

    private TreeNode leftRightCase(TreeNode node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private TreeNode rightLeftCase(TreeNode node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private TreeNode rightRightCase(TreeNode node) {
        node = leftRotation(node);
        swapColors(node, node.left);
        return node;
    }

    private TreeNode leftRotation(TreeNode node) {
        TreeNode nodeA = node;
        TreeNode nodeB = node.right;
        TreeNode nodeP = node.parent;
        nodeA.right = nodeB.left;

        if (nodeB.left != null) {
            nodeB.left.parent = nodeA;
        }

        nodeB.left = nodeA;
        nodeA.parent = nodeB;
        nodeB.parent = nodeP;
        if (nodeP != null) {
            if (nodeP.right != null && nodeP.right.key == nodeA.key) {
                nodeP.right = nodeB;
            }
            if (nodeP.left != null && nodeP.left.key == nodeA.key) {
                nodeP.left = nodeB;
            }
        } else {
            root = nodeB;
        }

        return nodeB;
    }

    private TreeNode rightRotation(TreeNode node) {
        TreeNode nodeA = node;
        TreeNode nodeB = node.left;
        TreeNode nodeP = node.parent;
        nodeA.left = nodeB.right;

        if (nodeB.right != null) {
            nodeB.right.parent = nodeA;
        }

        nodeB.right = nodeA;
        nodeA.parent = nodeB;
        nodeB.parent = nodeP;
        if (nodeP != null) {
            if (nodeP.right != null && nodeP.right.key == nodeA.key) {
                nodeP.right = nodeB;
            }
            if (nodeP.left != null && nodeP.left.key == nodeA.key) {
                nodeP.left = nodeB;
            }
        } else {
            root = nodeB;
        }

        return nodeB;
    }

    public List<K> getBFSRepresentation() {
        List<K> repr = new ArrayList<>();

        if (root == null) {
            return repr;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }

            repr.add(cur.key);
        }

        return repr;
    }
}
