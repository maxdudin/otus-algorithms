package otus.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree<K extends Comparable<K>, V> {
    private TreeNode root;

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
        int balanceFactor = 0;
        int height = 0;
        boolean deleted = false;
    }

    /**
     * Inserts a new node to a tree and does next operations:
     * 1. Looks for a place to insert a new node
     * 2. Updates nodes properties
     * 3. Does tree rebalancing
     * 4. Returns new tree root node
     *
     * @param newNode
     * @return
     */
    public void insert(TreeNode newNode) {
        if (root == null) {
            root = newNode;
            return;
        }

        insert(root, newNode);
    }

    private TreeNode insert(TreeNode subTree, TreeNode node) {
        if (subTree == null) {
            return node;
        }

        if (node.key.compareTo(subTree.key) < 0) {
            subTree.left = insert(subTree.left, node);
            subTree.left.parent = subTree;
        } else if (node.key.compareTo(subTree.key) > 0) {
            subTree.right = insert(subTree.right, node);
            subTree.right.parent = subTree;
        } else {
            subTree.equalElements.add(node);

            return subTree;
        }

        updateHeight(subTree);
        return balance(subTree);
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
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private TreeNode rightLeftCase(TreeNode node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    //incoming node means A node from picture
    //B is a left child of A
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

        updateHeight(nodeA);
        updateHeight(nodeB);

        return nodeB;
    }

    /**
     * removes an element with a given key from subtree
     * @param subTree
     * @param rmKey
     * @return a successor or deleted node if successor is not required
     */
    private TreeNode remove(TreeNode subTree, K rmKey) {
        if (subTree == null) {
            return null;
        }

        if (rmKey.compareTo(subTree.key) < 0) {
            TreeNode newLeftNode = remove(subTree.left, rmKey);
            if (newLeftNode == null) return null;
            if (newLeftNode.deleted) return newLeftNode;
            subTree.left = newLeftNode;

        } else if (rmKey.compareTo(subTree.key) > 0) {
            TreeNode newRightNode = remove(subTree.right, rmKey);
            if (newRightNode == null) return null;
            if (newRightNode.deleted) return newRightNode;
            subTree.right = newRightNode;

        } else {
            if (subTree.left == null) {
                return subTree.right;

            } else if (subTree.right == null) {
                return subTree.left;

            } else {
                if (!subTree.equalElements.isEmpty()) {
                    TreeNode del = subTree.equalElements.remove(0);
                    del.deleted = true;
                    return del;
                }

                TreeNode cur = subTree.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                TreeNode successor = cur;
                subTree.key = successor.key;
                subTree.value = successor.value;

                TreeNode replacement = remove(subTree.left, subTree.key);
                subTree.left = replacement;
            }
        }

        updateHeight(subTree);
        return balance(subTree);
    }
    //incoming node means A node from picture
    //B is a right child of A

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

        updateHeight(nodeA);
        updateHeight(nodeB);

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
