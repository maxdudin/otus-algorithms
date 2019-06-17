package otus.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedBlackTreeTest {
    @Test
    public void whenSimpleAVLTreeHasBeenCreated_ExpectItEqualToPreCalculated() {
        RedBlackTree<Integer, Integer> rbtree = new RedBlackTree<>();

        RedBlackTree<Integer, Integer>.TreeNode three = rbtree.new TreeNode(3, 3);
        rbtree.insert(three);
        List<Integer> expectedRepr3 = List.of(3);
        List<Integer> actualRepr3 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr3, actualRepr3);

        RedBlackTree<Integer, Integer>.TreeNode one = rbtree.new TreeNode(1, 1);
        rbtree.insert(one);
        List<Integer> expectedRepr1 = List.of(3, 1);
        List<Integer> actualRepr1 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr1, actualRepr1);

        RedBlackTree<Integer, Integer>.TreeNode five = rbtree.new TreeNode(5, 5);
        rbtree.insert(five);
        List<Integer> expectedRepr5 = List.of(3, 1, 5);
        List<Integer> actualRepr5 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr5, actualRepr5);

        RedBlackTree<Integer, Integer>.TreeNode seven = rbtree.new TreeNode(7, 7);
        rbtree.insert(seven);
        List<Integer> expectedRepr7 = List.of(3, 1, 5, 7);
        List<Integer> actualRepr7 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr7, actualRepr7);

        RedBlackTree<Integer, Integer>.TreeNode six = rbtree.new TreeNode(6, 6);
        rbtree.insert(six);
        List<Integer> expectedRepr6 = List.of(3, 1, 6, 5, 7);
        List<Integer> actualRepr6 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr6, actualRepr6);

        RedBlackTree<Integer, Integer>.TreeNode eight = rbtree.new TreeNode(8, 8);
        rbtree.insert(eight);
        List<Integer> expectedRepr8 = List.of(3, 1, 6, 5, 7, 8);
        List<Integer> actualRepr8 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr8, actualRepr8);

        RedBlackTree<Integer, Integer>.TreeNode nine = rbtree.new TreeNode(9, 9);
        rbtree.insert(nine);
        List<Integer> expectedRepr9 = List.of(3, 1, 6, 5, 8, 7, 9);
        List<Integer> actualRepr9 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr9, actualRepr9);

        RedBlackTree<Integer, Integer>.TreeNode ten = rbtree.new TreeNode(10, 10);
        rbtree.insert(ten);
        List<Integer> expectedRepr10 = List.of(6, 3, 8, 1, 5, 7, 9, 10);
        List<Integer> actualRepr10 = rbtree.getBFSRepresentation();
        assertEquals(expectedRepr10, actualRepr10);
    }
}
