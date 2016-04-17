package com.sbk.binarytrees;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CompleteTreeTest {

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        CompleteTree<Integer> tree = new CompleteTree<>();
        tree.insert(1,2,3,4,5,6,7);
        for(int i=1;i<=7;i++){
            assertThat(tree.find(i).value, equalTo(i));
        }
    }

    @Test
    public void testPreOrderTraversal() throws Exception {
        CompleteTree<Integer> tree = new CompleteTree<>();
        tree.insert(1,2,3,4,5,6,7);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        assertThat(tree.preOrderTraversal(), equalTo(expectedOrder));
    }


    @Test
    public void testToBinary() throws Exception {
        assertThat(CompleteTree.toBinary(5), equalTo("101"));
        assertThat(CompleteTree.toBinary(6), equalTo("110"));
        assertThat(CompleteTree.toBinary(13), equalTo("1101"));
    }

    @Test
    public void testInOrderTraversal() throws Exception {
        CompleteTree<Integer> tree = new CompleteTree<>();
        tree.insert(1,2,3,4,5,6,7);
        List<Integer> expectedOrder = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assertThat(tree.inOrderTraversal(), equalTo(expectedOrder));
    }

    @Test
    public void testIsEven() throws Exception {

    }
}