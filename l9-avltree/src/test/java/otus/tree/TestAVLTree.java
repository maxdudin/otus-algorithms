package otus.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAVLTree {
    @Test
    public void whenSimpleAVLTreeHasBeenCreated_ExpectItEqualToPreCalculated() {
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

        avlTree.remove(4);
        List<Integer> expectedRepr4rm = List.of(8, 3, 10, 2, 6, 9, 11, 1, 5, 7, 12);
        List<Integer> actualRepr4rm = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr4rm, actualRepr4rm);

        avlTree.remove(10);
        List<Integer> expectedRepr2rm = List.of(8, 3, 11, 2, 6, 9, 12, 1, 5, 7);
        List<Integer> actualRepr2rm = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr2rm, actualRepr2rm);
    }

    @Test
    public void whenAnotherSimpleTreehasBeenCreated_ExpectItEqualToPreCalculated() {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();

        AVLTree<Integer, Integer>.TreeNode seventyFive = avlTree.new TreeNode(75, 75);
        avlTree.insert(seventyFive);
        List<Integer> expectedRepr75 = List.of(75);
        List<Integer> actualRepr75 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr75, actualRepr75);

        AVLTree<Integer, Integer>.TreeNode sixtySix = avlTree.new TreeNode(66, 66);
        avlTree.insert(sixtySix);
        List<Integer> expectedRepr66 = List.of(75, 66);
        List<Integer> actualRepr66 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr66, actualRepr66);

        AVLTree<Integer, Integer>.TreeNode fiftyFive = avlTree.new TreeNode(55, 55);
        avlTree.insert(fiftyFive);
        List<Integer> expectedRepr55 = List.of(66, 55, 75);
        List<Integer> actualRepr55 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr55, actualRepr55);

        AVLTree<Integer, Integer>.TreeNode fourtyOne = avlTree.new TreeNode(41, 41);
        avlTree.insert(fourtyOne);
        List<Integer> expectedRepr41 = List.of(66, 55, 75, 41);
        List<Integer> actualRepr41 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr41, actualRepr41);

        AVLTree<Integer, Integer>.TreeNode thirtyThree = avlTree.new TreeNode(33, 33);
        avlTree.insert(thirtyThree);
        List<Integer> expectedRepr33 = List.of(66, 41, 75, 33, 55);
        List<Integer> actualRepr33 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr33, actualRepr33);

        AVLTree<Integer, Integer>.TreeNode sixtyOne = avlTree.new TreeNode(61, 61);
        avlTree.insert(sixtyOne);
        List<Integer> expectedRepr61 = List.of(55, 41, 66, 33, 61, 75);
        List<Integer> actualRepr61 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr61, actualRepr61);

        AVLTree<Integer, Integer>.TreeNode thirtySeven = avlTree.new TreeNode(37, 37);
        avlTree.insert(thirtySeven);
        List<Integer> expectedRepr37 = List.of(55, 37, 66, 33, 41, 61, 75);
        List<Integer> actualRepr37 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr37, actualRepr37);

        AVLTree<Integer, Integer>.TreeNode sixtyFive = avlTree.new TreeNode(65, 65);
        avlTree.insert(sixtyFive);
        List<Integer> expectedRepr65 = List.of(55, 37, 66, 33, 41, 61, 75, 65);
        List<Integer> actualRepr65 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr65, actualRepr65);

        AVLTree<Integer, Integer>.TreeNode seventyFour = avlTree.new TreeNode(74, 74);
        avlTree.insert(seventyFour);
        List<Integer> expectedRepr74 = List.of(55, 37, 66, 33, 41, 61, 75, 65, 74);
        List<Integer> actualRepr74 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr74, actualRepr74);

        AVLTree<Integer, Integer>.TreeNode seventy = avlTree.new TreeNode(70, 70);
        avlTree.insert(seventy);
        List<Integer> expectedRepr70 = List.of(55, 37, 66, 33, 41, 61, 74, 65, 70, 75);
        List<Integer> actualRepr70 = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr70, actualRepr70);

        avlTree.remove(66);
        List<Integer> expectedRepr66rm = List.of(55, 37, 65, 33, 41, 61, 74, 70, 75);
        List<Integer> actualRepr66rm = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr66rm, actualRepr66rm);

        avlTree.remove(37);
        List<Integer> expectedRepr37rm = List.of(55, 33, 65, 41, 61, 74, 70, 75);
        List<Integer> actualRepr37rm = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr37rm, actualRepr37rm);

        avlTree.remove(65);
        List<Integer> expectedRepr65rm = List.of(55, 33, 74, 41, 61, 75, 70);
        List<Integer> actualRepr65rm = avlTree.getBFSRepresentation();
        assertEquals(expectedRepr65rm, actualRepr65rm);
    }

}
