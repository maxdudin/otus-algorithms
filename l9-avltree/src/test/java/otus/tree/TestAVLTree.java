package otus.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAVLTree {
    @Test
    public void simpleAVLTreeCreationTest() {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();

        AVLTree<Integer, Integer>.TreeNode one = avlTree.new TreeNode(1, 1);
        avlTree.insert(one);
        List<Integer> expectedReprOne = List.of(1);
        List<Integer> actualReprOne = avlTree.getBFSRepresentation();
        assertEquals(expectedReprOne, actualReprOne);


        AVLTree<Integer, Integer>.TreeNode five = avlTree.new TreeNode(5, 5);
        avlTree.insert(five);
        List<Integer> expectedReprFive = List.of(1, 5);
        List<Integer> actualReprFive = avlTree.getBFSRepresentation();
        assertEquals(expectedReprFive, actualReprFive);


        AVLTree<Integer, Integer>.TreeNode four = avlTree.new TreeNode(4, 4);
        avlTree.insert(four);
        List<Integer> expectedReprFour = List.of(4, 1, 5);
        List<Integer> actualReprFour = avlTree.getBFSRepresentation();
        assertEquals(expectedReprFour, actualReprFour);


        AVLTree<Integer, Integer>.TreeNode two = avlTree.new TreeNode(2, 2);
        avlTree.insert(two);
        List<Integer> expectedReprTwo = List.of(4, 1, 5, 2);
        List<Integer> actualReprTwo = avlTree.getBFSRepresentation();
        assertEquals(actualReprTwo, expectedReprTwo);


        AVLTree<Integer, Integer>.TreeNode three = avlTree.new TreeNode(3, 3);
        avlTree.insert(three);
        List<Integer> expectedReprThree = List.of(4, 2, 5, 1, 3);
        List<Integer> actualReprThree = avlTree.getBFSRepresentation();
        assertEquals(actualReprThree, expectedReprThree);


        AVLTree<Integer, Integer>.TreeNode six = avlTree.new TreeNode(6, 6);
        avlTree.insert(six);
        List<Integer> expectedReprSix = List.of(4, 2, 5, 1, 3, 6);
        List<Integer> actualReprSix = avlTree.getBFSRepresentation();
        assertEquals(actualReprSix, expectedReprSix);


        AVLTree<Integer, Integer>.TreeNode nine = avlTree.new TreeNode(9, 9);
        avlTree.insert(nine);
        List<Integer> expectedReprNine = List.of(4, 2, 6, 1, 3, 5, 9);
        List<Integer> actualReprNine = avlTree.getBFSRepresentation();
        assertEquals(actualReprNine, expectedReprNine);


        AVLTree<Integer, Integer>.TreeNode eight = avlTree.new TreeNode(8, 8);
        avlTree.insert(eight);
        List<Integer> expectedReprEight = List.of(4, 2, 6, 1, 3, 5, 9, 8);
        List<Integer> actualReprEight = avlTree.getBFSRepresentation();
        assertEquals(actualReprEight, expectedReprEight);


        AVLTree<Integer, Integer>.TreeNode seven = avlTree.new TreeNode(7, 7);
        avlTree.insert(seven);
        List<Integer> expectedReprSeven = List.of(4, 2, 6, 1, 3, 5, 8, 7, 9);
        List<Integer> actualReprSeven = avlTree.getBFSRepresentation();
        assertEquals(actualReprSeven, expectedReprSeven);


        AVLTree<Integer, Integer>.TreeNode ten = avlTree.new TreeNode(10, 10);
        avlTree.insert(ten);
        List<Integer> expectedReprTen = List.of(4, 2, 8, 1, 3, 6, 9, 5, 7, 10);
        List<Integer> actualReprTen = avlTree.getBFSRepresentation();
        assertEquals(actualReprTen, expectedReprTen);


        AVLTree<Integer, Integer>.TreeNode eleven = avlTree.new TreeNode(11, 11);
        avlTree.insert(eleven);
        List<Integer> expectedReprEleven = List.of(4, 2, 8, 1, 3, 6, 10, 5, 7, 9, 11);
        List<Integer> actualReprEleven = avlTree.getBFSRepresentation();
        assertEquals(actualReprEleven, expectedReprEleven);


        AVLTree<Integer, Integer>.TreeNode twelve = avlTree.new TreeNode(12, 12);
        avlTree.insert(twelve);
        List<Integer> expectedReprTwelve = List.of(8, 4, 10, 2, 6, 9, 11, 1, 3, 5, 7, 12);
        List<Integer> actualReprTwelve = avlTree.getBFSRepresentation();
        assertEquals(actualReprTwelve, expectedReprTwelve);
    }

}
