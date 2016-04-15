package com.sbk.binarytrees;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by lol on 15.04.2016.
 */
public class CompleteTreeTest {

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        CompleteTree tree = new CompleteTree();
        for(int i=1;i<=7;i++){
            assertThat(tree.find(i).value, equalTo(i));
        }
    }

    @Test
    public void testPreOrderTraversal() throws Exception {

    }

    @Test
    public void testPreOrderTraversal1() throws Exception {

    }

    @Test
    public void testToBinary() throws Exception {
        assertThat(CompleteTree.toBinary(5), equalTo("101"));
        assertThat(CompleteTree.toBinary(6), equalTo("110"));
        assertThat(CompleteTree.toBinary(13), equalTo("1101"));
    }
}